Public Class clsBC_Usuario

    Dim isOK As New clsBE_Usuario

    Public Function ValidarUsuario(ByVal objBE As clsBE_Usuario) As clsBE_Usuario
        Try
            Dim isOK As New clsBE_Usuario

            If objBE.Usuario = "" Then
                isOK.Mensaje = "INGRESE UN USUARIO"
                isOK.Exito = False

                Return isOK
            End If

            If objBE.Clave = "" Then
                isOK.Mensaje = "INGRESE UNA CLAVE"
                isOK.Exito = False

                Return isOK
            End If

            isOK = (New clsDA_Usuario).ValidarUsuario(objBE)

            If isOK.Usuario Is Nothing Then
                isOK.Mensaje = "EL USUARIO O CLAVE NO SE ENCUENTRAN REGISTRADAS"
                isOK.Exito = False

                Return isOK
            End If

            If isOK.Clave Is Nothing Then
                isOK.Mensaje = "EL USUARIO O CLAVE NO SE ENCUENTRAN REGISTRADAS"
                isOK.Exito = False

                Return isOK
            End If

            


            If isOK.Usuario.ToUpper <> objBE.Usuario.ToUpper Then
                isOK.Mensaje = "EL USUARIO NO SE ENCUENTRA REGISTRADO"
                isOK.Exito = False

                Return isOK
            End If

            If isOK.Clave.ToUpper <> objBE.Clave.ToUpper Then
                isOK.Mensaje = "LA CLAVE INGRESA NO ES LA CORRECTA"
                isOK.Exito = False

                Return isOK
            End If

            isOK.Mensaje = "BIENVENIDO   " + isOK.Nombre.ToUpper + " " + isOK.Apellido.ToUpper
            isOK.Exito = True



            Return isOK
            ' Return (New clsDA_Usuario).ValidarUsuario(objBE)
        Catch ex As Exception
            isOK.Mensaje = "ERROR INESPERADO"
            Return isOK

        End Try
    End Function


End Class
