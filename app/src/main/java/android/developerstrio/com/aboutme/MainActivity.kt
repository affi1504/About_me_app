package android.developerstrio.com.aboutme

import android.content.Context
import android.developerstrio.com.aboutme.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private var myName: MyName = MyName("Aboobakkar Afrid")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.myName = myName

        binding.doneButton.setOnClickListener{
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {
    binding.apply {
        myName?.nickname = nicknameEdit.text.toString()

        invalidateAll()

        nicknameEdit.visibility = View.GONE
        doneButton.visibility = View.GONE

        nicknameText.visibility = View.VISIBLE
    }
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
