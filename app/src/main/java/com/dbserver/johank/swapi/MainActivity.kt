package com.dbserver.johank.swapi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

/*        val call = RetrofitInitializer().starWarsService().getCharacterOneAsTest()

        call.enqueue(object : Callback<Character> {
            override fun onResponse(call: Call<Character>?, response: Response<Character>?) {
                response?.body()?.let {
                    println("===============>${it.name} / ${it.gender} / ${it.birth_year}")
                }
            }

            override fun onFailure(call: Call<Character>?, t: Throwable?) {
                Log.e("onFailure", t?.message)
            }
        })*/

        val call2 = RetrofitInitializer().starWarsService().getCharacters()

        call2.enqueue(object : Callback<CharactersPage> {
            override fun onFailure(call: Call<CharactersPage>?, t: Throwable?) {
                Log.e("onFailure", t?.message)
            }

            override fun onResponse(call: Call<CharactersPage>?, response: Response<CharactersPage>?) {
                response?.body()?.let {
                    it.results.let {
                        it.forEach {
                            Log.d("response",it.name)
                        }
                    }
                }
            }

        })

    }
}
