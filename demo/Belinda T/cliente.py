"""Cliente: invoca una operacion en otro proceso mediante JSON-RPC."""
import argparse
import json
import sys
from urllib.error import HTTPError, URLError
from urllib.request import ProxyHandler, Request, build_opener


def consultar_docente_remoto(id_usuario, id_asignatura, puerto):
    # Esta funcion es nuestro representante local escrito a mano (stub sencillo).
    peticion = {
        "jsonrpc": "2.0",
        "method": "consultarDocenteAsignado",
        "params": {"idUsuario": id_usuario, "idAsignatura": id_asignatura},
        "id": 1,
    }
    print("PETICION JSON-RPC")
    print(json.dumps(peticion, indent=2, ensure_ascii=False))
    datos = json.dumps(peticion).encode("utf-8")  # Serializacion.
    solicitud = Request(
        f"http://127.0.0.1:{puerto}/rpc",
        data=datos,
        headers={"Content-Type": "application/json"},
        method="POST",
    )
    # Ambos procesos son locales: evitamos proxies del sistema para esta demo.
    with build_opener(ProxyHandler({})).open(solicitud, timeout=5) as respuesta_http:
        respuesta = json.loads(respuesta_http.read().decode("utf-8"))
    print("\nRESPUESTA JSON-RPC")
    print(json.dumps(respuesta, indent=2, ensure_ascii=False))
    if (not isinstance(respuesta, dict)
            or respuesta.get("jsonrpc") != "2.0"
            or type(respuesta.get("id")) is not int
            or respuesta["id"] != peticion["id"]
            or (("result" in respuesta) == ("error" in respuesta))):
        raise ValueError("La respuesta no coincide con la llamada JSON-RPC")
    if "error" in respuesta:
        detalle = respuesta["error"]
        raise ValueError(f"Error RPC {detalle['code']}: {detalle['message']}")
    return respuesta["result"]


def main():
    opciones = argparse.ArgumentParser(description="Consulta remota de docente")
    opciones.add_argument("id_usuario", nargs="?", type=int, default=101)
    opciones.add_argument("id_asignatura", nargs="?", type=int, default=12)
    opciones.add_argument("--puerto", type=int, default=8765)
    argumentos = opciones.parse_args()
    try:
        resultado = consultar_docente_remoto(
            argumentos.id_usuario, argumentos.id_asignatura, argumentos.puerto)
        if resultado["encontrado"]:
            docente = resultado["docente"]
            print(f"\nRESULTADO: {docente['fullName']} (ID {docente['teacherId']})")
        else:
            print("\nRESULTADO: Sin asignacion para ese usuario y asignatura.")
        return 0
    except (HTTPError, URLError, TimeoutError, OSError) as error:
        print(f"\nNo se pudo completar la comunicacion: {error}", file=sys.stderr)
        print("Comprueba que el servidor siga abierto en la terminal A "
              "y use el mismo puerto.", file=sys.stderr)
        return 1
    except (ValueError, KeyError, TypeError) as error:
        print(f"\n{error}", file=sys.stderr)
        return 1


if __name__ == "__main__":
    sys.exit(main())
