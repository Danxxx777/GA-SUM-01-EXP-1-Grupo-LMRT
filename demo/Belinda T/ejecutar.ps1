param(
    [Parameter(Mandatory = $true)]
    [ValidateSet('Servidor', 'Cliente')]
    [string]$Modo,
    [int]$IdUsuario = 101,
    [int]$IdAsignatura = 12,
    [ValidateRange(1, 65535)]
    [int]$Puerto = 8765
)

# PSScriptRoot permite ejecutar este archivo desde cualquier carpeta.
$pythonDemo = Get-Command python -ErrorAction SilentlyContinue
if (-not $pythonDemo) {
    throw 'No se encontro Python. Comprueba la instalacion con python --version.'
}
if ($Modo -eq 'Servidor') {
    & $pythonDemo.Source -B (Join-Path $PSScriptRoot 'servidor.py') --puerto $Puerto
} else {
    & $pythonDemo.Source -B (Join-Path $PSScriptRoot 'cliente.py') $IdUsuario $IdAsignatura --puerto $Puerto
}
exit $LASTEXITCODE
