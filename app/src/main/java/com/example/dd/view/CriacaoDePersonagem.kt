package com.example.dd.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import org.example.Personagem.Personagem
import org.example.Raca.AltoElfo
import org.example.Raca.Anao
import org.example.Raca.AnaoDaColina
import org.example.Raca.AnaoDaMontanha
import org.example.Raca.Draconato
import org.example.Raca.Drow
import org.example.Raca.Elfo
import org.example.Raca.ElfoDaFloresta
import org.example.Raca.Gnomo
import org.example.Raca.GnomoDaFloresta
import org.example.Raca.GnomoDasRochas
import org.example.Raca.Halfling
import org.example.Raca.HalflingPesLeves
import org.example.Raca.HalflingRobusto
import org.example.Raca.Humano
import org.example.Raca.MeioElfo
import org.example.Raca.MeioOrc
import org.example.Raca.Tiefling

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun criarPersonagem() {
    var personagem = Personagem()

    //variaveis para atribuição antes de irem para o personagem
    var nome by remember { mutableStateOf("") }
    var raca by remember { mutableStateOf("") }
    var forca by remember { mutableIntStateOf(8) }
    var destreza by remember { mutableIntStateOf(8) }
    var constituicao by remember { mutableIntStateOf(8) }
    var inteligencia by remember { mutableIntStateOf(8) }
    var sabedoria by remember { mutableIntStateOf(8) }
    var carisma by remember { mutableIntStateOf(8) }
    var pontosDisponiveis by remember { mutableIntStateOf(personagem.verificarPontosDisponiveis()) }

    //variavel do dialogo para a amostra do personagem
    var showDialog by remember { mutableStateOf(false) }

    //variveis de pontuação
    var expandedRaca by remember { mutableStateOf(false) }
    var expandedForca by remember { mutableStateOf(false) }
    var expandedDestreza by remember { mutableStateOf(false) }
    var expandedConstituicao by remember { mutableStateOf(false) }
    var expandedInteligencia by remember { mutableStateOf(false) }
    var expandedSabedoria by remember { mutableStateOf(false) }
    var expandedCarisma by remember { mutableStateOf(false) }
    var selectedOptionRaca by remember { mutableStateOf(raca) }
    //TODO adicionar numerações de listas para cada raça
    val opcoesRaca = listOf(
        "Alto Elfo",
        "Anão",
        "Anão da Colina",
        "Anão da Montanha",
        "Draconato",
        "Drow",
        "Elfo",
        "Elfo da Floresta",
        "Gnomo",
        "Gnomo da Floresta",
        "Gnomo das Rochas",
        "Halfling",
        "Halfling Pés Leves",
        "Halfling Robusto",
        "Humano",
        "Meio-Elfo",
        "Meio-Orc",
        "Tiefling"
    )
    val opcoesPontos = listOf(
        8,
        9,
        10,
        11,
        12,
        13,
        14,
        15
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(50.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Criação de Personagem",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ){
            Text(
                text = "Pontos disponiveis:",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
            )
            Text(
                text = pontosDisponiveis.toString(),
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
            )
        }
        TextField(
            value = nome,
            onValueChange = { nome = it },
            label = { Text("Nome Personagem") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        ExposedDropdownMenuBox(
            expanded = expandedRaca,
            onExpandedChange = { expandedRaca = !expandedRaca },
            modifier = Modifier.fillMaxWidth()
        ) {
            TextField(
                readOnly = true,
                value = raca,
                onValueChange = { },
                label = { Text("Raça") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedRaca) },
                modifier = Modifier
                    .fillMaxWidth()
                    .menuAnchor()
            )
            ExposedDropdownMenu(
                expanded = expandedRaca,
                onDismissRequest = { expandedRaca = false }
            ) {
                opcoesRaca.forEach { selectionOption ->
                    DropdownMenuItem(
                        onClick = {
                            raca = selectionOption
                            expandedRaca = false
                        },
                        text = { Text(selectionOption) }
                    )
                }
            }
        }
        ExposedDropdownMenuBox(
            expanded = expandedForca,
            onExpandedChange = { expandedForca = !expandedForca },
            modifier = Modifier.fillMaxWidth()
        ) {
            TextField(
                readOnly = true,
                value = forca.toString(),
                onValueChange = { },
                label = { Text("Força") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedForca) },
                modifier = Modifier
                    .fillMaxWidth()
                    .menuAnchor()
            )
            ExposedDropdownMenu(
                expanded = expandedForca,
                onDismissRequest = { expandedForca = false }
            ) {
                opcoesPontos.forEach { selectionOption ->
                    DropdownMenuItem(
                        onClick = {
                            forca = selectionOption
                            expandedForca = false
                        },
                        text = { Text(selectionOption.toString()) }
                    )
                }
            }
        }
        ExposedDropdownMenuBox(
            expanded = expandedDestreza,
            onExpandedChange = { expandedDestreza = !expandedDestreza },
            modifier = Modifier.fillMaxWidth()
        ) {
            TextField(
                readOnly = true,
                value = destreza.toString(),
                onValueChange = { },
                label = { Text("Destreza") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedDestreza) },
                modifier = Modifier
                    .fillMaxWidth()
                    .menuAnchor()
            )
            ExposedDropdownMenu(
                expanded = expandedDestreza,
                onDismissRequest = { expandedDestreza = false }
            ) {
                opcoesPontos.forEach { selectionOption ->
                    DropdownMenuItem(
                        onClick = {
                            destreza = selectionOption
                            expandedDestreza = false
                        },
                        text = { Text(selectionOption.toString()) }
                    )
                }
            }
        }
        ExposedDropdownMenuBox(
            expanded = expandedConstituicao,
            onExpandedChange = { expandedConstituicao = !expandedConstituicao },
            modifier = Modifier.fillMaxWidth()
        ) {
            TextField(
                readOnly = true,
                value = constituicao.toString(),
                onValueChange = { },
                label = { Text("Constituição") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedConstituicao) },
                modifier = Modifier
                    .fillMaxWidth()
                    .menuAnchor()
            )
            ExposedDropdownMenu(
                expanded = expandedConstituicao,
                onDismissRequest = { expandedConstituicao = false }
            ) {
                opcoesPontos.forEach { selectionOption ->
                    DropdownMenuItem(
                        onClick = {
                            constituicao = selectionOption
                            expandedConstituicao = false
                        },
                        text = { Text(selectionOption.toString()) }
                    )
                }
            }
        }
        ExposedDropdownMenuBox(
            expanded = expandedInteligencia,
            onExpandedChange = { expandedInteligencia = !expandedInteligencia },
            modifier = Modifier.fillMaxWidth()
        ) {
            TextField(
                readOnly = true,
                value = inteligencia.toString(),
                onValueChange = { },
                label = { Text("Inteligência") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedInteligencia) },
                modifier = Modifier
                    .fillMaxWidth()
                    .menuAnchor()
            )
            ExposedDropdownMenu(
                expanded = expandedInteligencia,
                onDismissRequest = { expandedInteligencia = false }
            ) {
                opcoesPontos.forEach { selectionOption ->
                    DropdownMenuItem(
                        onClick = {
                            inteligencia = selectionOption
                            expandedInteligencia = false
                        },
                        text = { Text(selectionOption.toString()) }
                    )
                }
            }
        }
        ExposedDropdownMenuBox(
            expanded = expandedSabedoria,
            onExpandedChange = { expandedSabedoria = !expandedSabedoria },
            modifier = Modifier.fillMaxWidth()
        ) {
            TextField(
                readOnly = true,
                value = sabedoria.toString(),
                onValueChange = { },
                label = { Text("Sabedoria") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedSabedoria) },
                modifier = Modifier
                    .fillMaxWidth()
                    .menuAnchor()
            )
            ExposedDropdownMenu(
                expanded = expandedSabedoria,
                onDismissRequest = { expandedSabedoria = false }
            ) {
                opcoesPontos.forEach { selectionOption ->
                    DropdownMenuItem(
                        onClick = {
                            sabedoria = selectionOption
                            expandedSabedoria = false
                        },
                        text = { Text(selectionOption.toString()) }
                    )
                }
            }
        }
        ExposedDropdownMenuBox(
            expanded = expandedCarisma,
            onExpandedChange = { expandedCarisma = !expandedCarisma },
            modifier = Modifier.fillMaxWidth()
        ) {
            TextField(
                readOnly = true,
                value = carisma.toString(),
                onValueChange = { },
                label = { Text("Carisma") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedCarisma) },
                modifier = Modifier
                    .fillMaxWidth()
                    .menuAnchor()
            )
            ExposedDropdownMenu(
                expanded = expandedCarisma,
                onDismissRequest = { expandedCarisma = false }
            ) {
                opcoesPontos.forEach { selectionOption ->
                    DropdownMenuItem(
                        onClick = {
                            carisma = selectionOption
                            expandedCarisma = false
                        },
                        text = { Text(selectionOption.toString()) }
                    )
                }
            }
        }
        when(raca) {
            "Alto Elfo" -> personagem.escolherRaca(1)
            "Anão" -> personagem.escolherRaca(2)
            "Anão da Colina" -> personagem.escolherRaca(3)
            "Anão da Montanha" -> personagem.escolherRaca(4)
            "Draconato" -> personagem.escolherRaca(5)
            "Drow" -> personagem.escolherRaca(6)
            "Elfo" -> personagem.escolherRaca(7)
            "Elfo da Floresta" -> personagem.escolherRaca(8)
            "Gnomo" -> personagem.escolherRaca(9)
            "Gnomo da Floresta" -> personagem.escolherRaca(10)
            "Gnomo das Rochas" -> personagem.escolherRaca(11)
            "Halfling" -> personagem.escolherRaca(12)
            "Halfling Pés Leves" -> personagem.escolherRaca(13)
            "Halfling Robusto" -> personagem.escolherRaca(14)
            "Humano" -> personagem.escolherRaca(15)
            "Meio-Elfo" -> personagem.escolherRaca(16)
            "Meio-Orc" -> personagem.escolherRaca(17)
            else -> personagem.escolherRaca(18)
        }
        personagem.nome = nome
//        personagem.raca = personagem.escolherRaca(raca)
        personagem.forca = forca
        personagem.destreza = destreza
        personagem.constituicao = constituicao
        personagem.inteligencia = inteligencia
        personagem.sabedoria = sabedoria
        personagem.carisma = carisma
        pontosDisponiveis = personagem.verificarPontosDisponiveis()
        var buttonEnabled = true
        if (pontosDisponiveis < 0 ){
            buttonEnabled = false
        }
        Button(
            onClick = {showDialog = true},
            modifier = Modifier
                .fillMaxWidth(),
            enabled = buttonEnabled
        ) {
            Text(
                "Criar Personagem",
            )
        }
        if (showDialog) {
            Dialog(onDismissRequest = { showDialog = false }) {
                Card {
                    Column (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){


                        personagem.definirPontosDeVida()
                        personagem.adicionarBonusHabilidade()
                        Text("Personagem criado com sucesso!")
                        Text("Nome: ${personagem.nome}")
                        Text("Pontos de Vida: ${personagem.pontosDeVida}")
//                        Text("Raça: ${personagem.raca}")
                        Text("Força: ${personagem.forca}")
                        Text("Destreza: ${personagem.destreza}")
                        Text("Constituição: ${personagem.constituicao}")
                        Text("Inteligência: ${personagem.inteligencia}")
                        Text("Sabedoria: ${personagem.sabedoria}")
                        Text("Carisma: ${personagem.carisma}")
                    }
                }
            }
        }
    }
}