package br.com.faculdadeimpacta.usuarioroom.ui.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.com.faculdadeimpacta.usuarioroom.R
import br.com.faculdadeimpacta.usuarioroom.data.repositories.UsuarioRepository
import br.com.faculdadeimpacta.usuarioroom.data.sources.local.database.RoomDB

class MainActivity : AppCompatActivity() {

    private val roomDB by lazy {
        RoomDB.getInstance(this)
    }
    private val usuarioDAO by lazy {
        roomDB.getUsuarioDAO()
    }
    val usuarioRepository by lazy {
        UsuarioRepository(usuarioDAO)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}