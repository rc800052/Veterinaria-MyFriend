Imports System.Web.Services
Imports System.Web.Services.Protocols
Imports System.ComponentModel

' Para permitir que se llame a este servicio Web desde un script, usando ASP.NET AJAX, quite la marca de comentario de la línea siguiente.
' <System.Web.Script.Services.ScriptService()> _
<System.Web.Services.WebService(Namespace:="http://tempuri.org/")> _
<System.Web.Services.WebServiceBinding(ConformsTo:=WsiProfiles.BasicProfile1_1)> _
<ToolboxItem(False)> _
Public Class Service1
    Inherits System.Web.Services.WebService

    <WebMethod()> _
    Public Function HelloWorld() As String
       Return "Hola a todos"
    End Function

    <WebMethod()> _
    Public Function ValidarUsuario(ByVal usuario As String, ByVal password As String) As clsBE_Usuario
        Try
            Dim objBE As New clsBE_Usuario
            objBE.Usuario = usuario
            objBE.Clave = password

            Return (New clsBC_Usuario).ValidarUsuario(objBE)
        Catch ex As Exception
            Throw
        End Try
    End Function

End Class