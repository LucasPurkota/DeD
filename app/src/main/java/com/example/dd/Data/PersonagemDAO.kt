package com.example.dd.Data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.dd.view.PersonagemDB

@Dao
interface PersonagemDAO {
    @Insert
    suspend fun insert(personagem: PersonagemDB)

    @Query("SELECT * FROM personagem")
    suspend fun getAllPersonagens(): List<PersonagemDB>

    @Delete
    suspend fun delete(personagem: PersonagemDB)

    @Query("UPDATE personagem SET nome = :novoNome WHERE id = :id")
    suspend fun update(id: Int, novoNome: String)

    @Query("SELECT * FROM personagem WHERE id = :id")
    suspend fun getPersonagemById(id: Int): PersonagemDB?
}

