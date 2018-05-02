package com.dbserver.johank.swapi

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.View
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var hasNext: Boolean = false
    private var firstRun: Boolean = true
    private var nextPageUrl: String? = null

    private val charactersList = mutableListOf<Character>()
    private lateinit var recyclerView : RecyclerView
    private lateinit var adapter: CharacterAdapter
    private lateinit var progressDialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buildAlertDialogForProgress()
        getAllCharacters()

    }

    private fun buildAlertDialogForProgress(){
        val dialogView = View.inflate(this, R.layout.custom_dialog_progress, null)
        val builder = AlertDialog.Builder(this)
        val message = dialogView.findViewById<TextView>(R.id.messageDialog)

        message.text = getString(R.string.loading_characters)
        builder.setView(dialogView)
        builder.setCancelable(false)
        progressDialog = builder.create()
    }

    /*private fun firstTest(){
        val call = RetrofitInitializer().starWarsService().getCharacterOneAsTest()

        call.enqueue(object : Callback<Character> {
            override fun onResponse(call: Call<Character>?, response: Response<Character>?) {
                response?.body()?.let {
                    println("===============>${it.name} / ${it.gender} / ${it.birth_year}")
                }
            }

            override fun onFailure(call: Call<Character>?, t: Throwable?) {
                Log.e("onFailure", t?.message)
            }
        })
    }

    private fun secondTest(){
        val call = RetrofitInitializer().starWarsService().getCharacters()

        call.enqueue(object : Callback<CharactersPage> {
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
    }*/

    private fun getAllCharacters(){

        progressDialog.show()

        if(firstRun) {
            val call = RetrofitInitializer().starWarsService().getCharacters()

            call.enqueue(object : Callback<CharactersPage> {
                override fun onFailure(call: Call<CharactersPage>?, t: Throwable?) {
                    println(t?.message)
                }

                override fun onResponse(call: Call<CharactersPage>?, response: Response<CharactersPage>?) {
                    response?.body()?.let {

                        if (it.next != null) {
                            hasNext = true
                            nextPageUrl = it.next
                        } else {
                            hasNext = false
                        }

                        it.results.forEach {
                            charactersList.add(it)
                        }
                    }
                    firstRun = false
                    getAllCharacters()
                }
            })
        } else {
            if(hasNext) {
                val call = RetrofitInitializer().starWarsService().getCharactersPage(nextPageUrl!!)

                call.enqueue(object : Callback<CharactersPage> {
                    override fun onFailure(call: Call<CharactersPage>?, t: Throwable?) {
                        println(t?.message)
                    }

                    override fun onResponse(call: Call<CharactersPage>?, response: Response<CharactersPage>?) {
                        response?.body()?.let{
                            if (it.next != null) {
                                hasNext = true
                                nextPageUrl = it.next
                            } else {
                                hasNext = false
                            }

                            it.results.forEach {
                                charactersList.add(it)
                            }
                        }
                        getAllCharacters()
                    }
                })
            } else {
                initRecyclerView()
                progressDialog.dismiss()
                recyclerView.visibility = View.VISIBLE
            }
        }
    }

    private fun initRecyclerView(){
        recyclerView = findViewById(R.id.characterRecyclerView)
        adapter = CharacterAdapter(charactersList, this)
        recyclerView.adapter = adapter

        val layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager
    }

}
