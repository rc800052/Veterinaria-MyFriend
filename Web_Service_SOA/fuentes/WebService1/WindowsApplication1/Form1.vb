Imports WindowsApplication1.ServiceReference1

Public Class Form1

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        'Try
        '    Dim objBE As New ServiceReference1.clsBE_Usuario
        '    objBE.UserName = Me.TextBox1.Text.Trim
        '    objBE.Password = Me.TextBox2.Text.Trim

        '    Dim objSW As New ServiceReference1.Service1SoapClient

        '    If objSW.ValidarUsuario(objBE) Then
        '        MessageBox.Show("Ingreso")
        '    Else
        '        MessageBox.Show("Usuario o Password invalido")
        '    End If
        'Catch ex As Exception
        '    MessageBox.Show(ex.Message)
        'End Try

        Dim objSWw As New ServiceReference1.Service1SoapClient
        MsgBox(objSWw.HelloWorld())



    End Sub

    Private Sub Button2_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button2.Click
        Try
            'Dim objBE As New ServiceReference1.
            'objBE.UserName = Me.TextBox1.Text.Trim
            'objBE.Password = Me.TextBox2.Text.Trim

            Dim objSW As New ServiceReference1.Service1SoapClient

            '   If objSW.ValidarUsuario(Me.TextBox1.Text.Trim, Me.TextBox2.Text.Trim) Then
            'MessageBox.Show("Ingreso dddd")
            'Else
            'MessageBox.Show("Usuario o Password invalido")
            'End If
            Dim objeto As New clsBE_Usuario
            objeto = objSW.ValidarUsuario(Me.TextBox1.Text.Trim, Me.TextBox2.Text.Trim)

            MessageBox.Show("Usuario " + objeto.Usuario)

        Catch ex As Exception
            MessageBox.Show(ex.Message)
        End Try
    End Sub
End Class
