package com.dbserver.johank.swapi

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class CharacterAdapter (private val characterList: MutableList<Character>,
                        private val context: Context) : RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bindView(character : Character){

            val nameTextView = itemView.findViewById<TextView>(R.id.nameTextView)
            val genderTextView = itemView.findViewById<TextView>(R.id.genderTextView)
            val heightTextView = itemView.findViewById<TextView>(R.id.heightTextView)
            val massTextView = itemView.findViewById<TextView>(R.id.massTextView)
            val birthTextView = itemView.findViewById<TextView>(R.id.birthTextView)
            val hairTextView = itemView.findViewById<TextView>(R.id.hairTextView)
            val eyeTextView = itemView.findViewById<TextView>(R.id.eyeTextView)
            val skinTextView = itemView.findViewById<TextView>(R.id.skinTextView)

            nameTextView.text = character.name
            genderTextView.text = character.gender
            heightTextView.text = if(character.height != "unknown") "${character.height} cm" else character.height
            massTextView.text = if(character.mass != "unknown") "${character.mass} kg" else character.mass
            birthTextView.text = character.birth_year
            hairTextView.text = character.hair_color
            eyeTextView.text = character.eye_color
            skinTextView.text = character.skin_color
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.cardview_character, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = characterList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = characterList[position]
        holder.bindView(character)
    }

}