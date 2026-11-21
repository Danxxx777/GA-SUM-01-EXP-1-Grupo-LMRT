"""Demo didactica JSON-RPC 2.0 sobre HTTP; datos ficticios en memoria."""
import argparse
import json
from http.server import BaseHTTPRequestHandler, HTTPServer

# Clave: (usuario, asignatura). No se consulta la base de SGRA.
DOCENTES = {
    (101, 12): {
        "teacherId": 7,
        "fullName": "Docente de ejemplo",
        "email": "docente@example.org",
    }
}


def error_rpc(codigo, mensaje, identificador=None):
    return {"jsonrpc": "2.0", "error": {"code": codigo, "message": mensaje},
            "id": identificador}


def consultar_docente_asignado(idUsuario, idAsignatura):
    """Operacion de negocio: una consulta de solo lectura."""
    docente = DOCENTES.get((idUsuario, idAsignatura))
    return {"encontrado": docente is not None, "docente": docente}


def despachar(peticion):
    """Valida el sobre RPC, selecciona el metodo y construye su respuesta."""
    if not isinstance(peticion, dict):
        return error_rpc(-32600, "Peticion invalida")
    identificador = peticion.get("id")
    id_valido = identificador is None or type(identificador) in (str, int, float)
    if (peticion.get("jsonrpc") != "2.0"
            or not isinstance(peticion.get("method"), str) or not id_valido
            or ("params" in peticion and
                not isinstance(peticion["params"], (dict, list)))):
        return error_rpc(-32600, "Peticion invalida")

    notificacion = "id" not in peticion
    if peticion["method"] != "consultarDocenteAsignado":
        respuesta = error_rpc(-32601, "Metodo no encontrado", identificador)
    else:
        parametros = peticion.get("params", {})
        nombres = {"idUsuario", "idAsignatura"}
        validos = (isinstance(parametros, dict)
                   and set(parametros) == nombres
                   and all(type(parametros[n]) is int and parametros[n] > 0
                           for n in nombres))
        if not validos:
            respuesta = error_rpc(-32602,
                                  "Use idUsuario e idAsignatura enteros positivos",
                                  identificador)
        else:
            resultado = consultar_docente_asignado(**parametros)
            respuesta = {"jsonrpc": "2.0", "result": resultado, "id": identificador}
            print(f"Operacion: {peticion['method']} | {parametros} | {resultado}",
                  flush=True)
    # Las notificaciones validas no reciben respuesta, incluso si el metodo falla.
    return None if notificacion else respuesta


def procesar_mensaje(mensaje):
    if not isinstance(mensaje, list):
        return despachar(mensaje)
    if not mensaje:
        return error_rpc(-32600, "Lote vacio")
    respuestas = [despachar(peticion) for peticion in mensaje]
    respuestas = [respuesta for respuesta in respuestas if respuesta is not None]
    return respuestas or None


class ManejadorRPC(BaseHTTPRequestHandler):
    def do_POST(self):
        if self.path != "/rpc":
            self.send_error(404, "Use /rpc")
            return
        try:
            longitud = int(self.headers.get("Content-Length", "0"))
            mensaje = json.loads(self.rfile.read(longitud))
        except (ValueError, UnicodeDecodeError):
            respuesta = error_rpc(-32700, "JSON no valido")
        else:
            try:
                respuesta = procesar_mensaje(mensaje)
            except Exception:
                respuesta = error_rpc(-32603, "Error interno")

        if respuesta is None:
            self.send_response(204)
            self.end_headers()
            return
        contenido = json.dumps(respuesta, ensure_ascii=False).encode("utf-8")
        self.send_response(200)
        self.send_header("Content-Type", "application/json; charset=utf-8")
        self.send_header("Content-Length", str(len(contenido)))
        self.end_headers()
        self.wfile.write(contenido)

    def log_message(self, formato, *argumentos):
        pass  # La consola muestra la operacion en vez del log HTTP generico.


def main():
    opciones = argparse.ArgumentParser(description="Servidor JSON-RPC de ejemplo")
    opciones.add_argument("--puerto", type=int, default=8765)
    argumentos = opciones.parse_args()
    try:
        with HTTPServer(("127.0.0.1", argumentos.puerto), ManejadorRPC) as servidor:
            print(f"Servidor listo: http://127.0.0.1:{servidor.server_port}/rpc",
                  flush=True)
            print("Datos ficticios. Deja esta terminal abierta. Ctrl+C para salir.",
                  flush=True)
            servidor.serve_forever()
    except KeyboardInterrupt:
        print("\nServidor detenido.")
    except OSError as error:
        opciones.exit(1, f"No se pudo iniciar el servidor: {error}\n")


if __name__ == "__main__":
    main()
