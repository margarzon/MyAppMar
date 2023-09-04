import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myappmar.MenuActivity
import com.example.myappmar.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val usuario = "usuario"
        val contraseña = "contraseña"

        val editTextUsuario = findViewById<EditText>(R.id.editTextUsuario)
        val editTextContraseña = findViewById<EditText>(R.id.editTextContraseña)
        val buttonIniciarSesion = findViewById<Button>(R.id.buttonIniciarSesion)

        buttonIniciarSesion.setOnClickListener {
            val inputUsuario = editTextUsuario.text.toString()
            val inputContraseña = editTextContraseña.text.toString()

            if (inputUsuario == usuario && inputContraseña == contraseña) {
                // Inicio de sesión exitoso
                Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()

                // Crear un Intent para abrir la actividad de menú
                val intent = Intent(this, MenuActivity::class.java)
                startActivity(intent)
            } else {
                // Error de inicio de sesión
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
