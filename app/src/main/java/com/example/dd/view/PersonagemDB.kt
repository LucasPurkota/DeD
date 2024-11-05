package com.example.dd.view

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "personagem")
class PersonagemDB {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    var nome: String = ""
    var raca: String = ""
    var pontosDeVida : Int = 0
    var nivel: Int = 0
    var xp: Double = 0.0
    var forca : Int = 0
    var destreza : Int = 0
    var constituicao : Int = 0
    var inteligencia : Int = 0
    var sabedoria : Int = 0
    var carisma : Int = 0
}