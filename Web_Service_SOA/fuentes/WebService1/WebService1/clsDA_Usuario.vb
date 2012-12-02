Imports System.Data.SqlClient

Public Class clsDA_Usuario

    Protected sqlCnn As SqlConnection
    Protected sqlCmd As SqlCommand

    Public Function ValidarUsuario(ByVal objBE As clsBE_Usuario) As clsBE_Usuario
        Dim dtReader As SqlDataReader
        Dim isOK As New clsBE_Usuario

        Try
            Me.sqlCnn = New SqlConnection(ConfigurationManager.ConnectionStrings("Database").ConnectionString)
            Me.sqlCnn.Open()

            Me.sqlCmd = New SqlCommand("usp_Usuario_g_Login", Me.sqlCnn)
            Me.sqlCmd.CommandType = CommandType.StoredProcedure

            With objBE

                Me.sqlCmd.Parameters.Add("@pisUserName", SqlDbType.VarChar, 50).Value = objBE.Usuario
                Me.sqlCmd.Parameters.Add("@pisPassword", SqlDbType.VarChar, 50).Value = objBE.Clave

            End With

            dtReader = Me.sqlCmd.ExecuteReader()

            With dtReader
                If .HasRows Then
                    While .Read()
                        isOK.ID = dtReader.GetValue(0)
                        isOK.Apellido = dtReader.GetString(1)
                        isOK.Nombre = dtReader.GetString(2)
                        isOK.Email = dtReader.GetString(3)
                        isOK.Telefono = dtReader.GetString(4)
                        isOK.Usuario = dtReader.GetString(5)
                        isOK.Clave = dtReader.GetString(6)
                        isOK.Perfil = dtReader.GetString(7)

                        Exit While
                    End While
                End If

                .Close()
            End With

            If Me.sqlCnn IsNot Nothing AndAlso Me.sqlCnn.State <> ConnectionState.Closed Then
                Me.sqlCnn.Close()
            End If

            Return isOK
        Catch ex As Exception
            Throw
        Finally
            dtReader = Nothing
            Me.sqlCmd = Nothing
        End Try
    End Function

End Class
