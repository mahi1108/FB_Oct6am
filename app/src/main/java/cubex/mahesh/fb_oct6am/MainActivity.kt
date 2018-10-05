package cubex.mahesh.fb_oct6am

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.gms.ads.AdRequest
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import com.google.android.gms.ads.AdView




class MainActivity : AppCompatActivity() {

    private var mAuth: FirebaseAuth? = null
    private var mAdView: AdView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mAuth = FirebaseAuth.getInstance();

        mAdView = findViewById<AdView>(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView!!.loadAd(adRequest)


        login.setOnClickListener {

            mAuth!!.signInWithEmailAndPassword(et1.text.toString(),
    et2.text.toString()).addOnCompleteListener {
                if(it.isSuccessful){
                    Toast.makeText(this@MainActivity,
                            "Authentication is Success...",
                            Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this@MainActivity,
                            "Authentication is Failed...",
                            Toast.LENGTH_LONG).show()
                }
            }

        }

        register.setOnClickListener {
            mAuth!!.createUserWithEmailAndPassword(et1.text.toString(),
      et2.text.toString()).addOnCompleteListener {
                if(it.isSuccessful){
                        Toast.makeText(this@MainActivity,
                                "Registration is Success...",
                                Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this@MainActivity,
                            "Registration is Failed...",
                            Toast.LENGTH_LONG).show()
                }
            }
        }

    }
}
