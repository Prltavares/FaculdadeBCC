"use client";

import { useEffect, useMemo, useState } from "react";
import {
  CalendarDays,
  ChevronDown,
  Clock,
  Heart,
  MapPin,
  Sparkles,
  Star,
  Trophy,
  Users,
} from "lucide-react";

// Mock usado como "banco de dados" inicial da aplicação.
const worldCupTeams = [
  {
    id: "mexico",
    nome: "México",
    flag: "🇲🇽",
    grupo: "A",
    descricao: "Co-anfitrião buscando usar a força da torcida no Azteca para ir longe.",
    destaques: ["Santiago Giménez", "Edson Álvarez"],
    jogos: [
      { data: "11/06", horario: "16:00", adversario: "África do Sul", local: "Estádio Azteca, Cidade do México" },
      { data: "18/06", horario: "22:00", adversario: "Coreia do Sul", local: "Estádio Akron, Zapopan/Guadalajara" },
      { data: "24/06", horario: "22:00", adversario: "Rep. Tcheca", local: "Estádio Azteca, Cidade do México" },
    ],
  },
  {
    id: "africa-do-sul",
    nome: "África do Sul",
    flag: "🇿🇦",
    grupo: "A",
    descricao: "Retorna após longa ausência com uma geração veloz.",
    destaques: ["Lyle Foster", "Percy Tau"],
    jogos: [
      { data: "11/06", horario: "16:00", adversario: "México", local: "Estádio Azteca, Cidade do México" },
      { data: "18/06", horario: "13:00", adversario: "Rep. Tcheca", local: "Mercedes-Benz Stadium, Atlanta" },
      { data: "24/06", horario: "22:00", adversario: "Coreia do Sul", local: "Estádio BBVA, Monterrey" },
    ],
  },
  {
    id: "coreia-do-sul",
    nome: "Coreia do Sul",
    flag: "🇰🇷",
    grupo: "A",
    descricao: "Potência asiática com transições rápidas ao ataque.",
    destaques: ["Son Heung-min", "Kim Min-jae"],
    jogos: [
      { data: "11/06", horario: "23:00", adversario: "Rep. Tcheca", local: "Estádio Akron, Zapopan/Guadalajara" },
      { data: "18/06", horario: "22:00", adversario: "México", local: "Estádio Akron, Zapopan/Guadalajara" },
      { data: "24/06", horario: "22:00", adversario: "África do Sul", local: "Estádio BBVA, Monterrey" },
    ],
  },
  {
    id: "republica-tcheca",
    nome: "República Tcheca",
    flag: "🇨🇿",
    grupo: "A",
    descricao: "Sólida na defesa e mortal nas bolas paradas.",
    destaques: ["Patrik Schick", "Tomáš Souček"],
    jogos: [
      { data: "11/06", horario: "23:00", adversario: "Coreia do Sul", local: "Estádio Akron, Zapopan/Guadalajara" },
      { data: "18/06", horario: "13:00", adversario: "África do Sul", local: "Mercedes-Benz Stadium, Atlanta" },
      { data: "24/06", horario: "22:00", adversario: "México", local: "Estádio Azteca, Cidade do México" },
    ],
  },
  {
    id: "canada",
    nome: "Canadá",
    flag: "🇨🇦",
    grupo: "B",
    descricao: "Aposta na velocidade pelos lados do campo atuando em casa.",
    destaques: ["Alphonso Davies", "Jonathan David"],
    jogos: [
      { data: "12/06", horario: "16:00", adversario: "Bósnia", local: "BMO Field, Toronto" },
      { data: "18/06", horario: "19:00", adversario: "Catar", local: "BC Place, Vancouver" },
      { data: "24/06", horario: "16:00", adversario: "Suíça", local: "Lumen Field, Seattle" },
    ],
  },
  {
    id: "catar",
    nome: "Catar",
    flag: "🇶🇦",
    grupo: "B",
    descricao: "Atual bicampeão asiático tentando provar seu valor fora de casa.",
    destaques: ["Akram Afif", "Almoez Ali"],
    jogos: [
      { data: "12/06", horario: "16:00", adversario: "Suíça", local: "Levi's Stadium, Santa Clara" },
      { data: "18/06", horario: "19:00", adversario: "Canadá", local: "BC Place, Vancouver" },
      { data: "24/06", horario: "16:00", adversario: "Bósnia", local: "Lumen Field, Seattle" },
    ],
  },
  {
    id: "suica",
    nome: "Suíça",
    flag: "🇨🇭",
    grupo: "B",
    descricao: "Constância pura; costuma avançar sempre de fase.",
    destaques: ["Granit Xhaka", "Manuel Akanji"],
    jogos: [
      { data: "12/06", horario: "16:00", adversario: "Catar", local: "Levi's Stadium, Santa Clara" },
      { data: "18/06", horario: "16:00", adversario: "Bósnia", local: "SoFi Stadium, Los Angeles" },
      { data: "24/06", horario: "16:00", adversario: "Canadá", local: "Lumen Field, Seattle" },
    ],
  },
  {
    id: "bosnia-e-herzegovina",
    nome: "Bósnia e Herzegovina",
    flag: "🇧🇦",
    grupo: "B",
    descricao: "Físico forte e dependência dos seus centroavantes.",
    destaques: ["Edin Džeko", "Ermedin Demirović"],
    jogos: [
      { data: "12/06", horario: "16:00", adversario: "Canadá", local: "BMO Field, Toronto" },
      { data: "18/06", horario: "16:00", adversario: "Suíça", local: "SoFi Stadium, Los Angeles" },
      { data: "24/06", horario: "16:00", adversario: "Catar", local: "Lumen Field, Seattle" },
    ],
  },
  {
    id: "brasil",
    nome: "Brasil",
    flag: "🇧🇷",
    grupo: "C",
    descricao: "Chega em busca do Hexa sob grande pressão ofensiva e renovação.",
    destaques: ["Vini Jr.", "Rodrygo", "Endrick"],
    jogos: [
      { data: "12/06", horario: "19:00", adversario: "Marrocos", local: "MetLife Stadium, Nova York/NJ" },
      { data: "19/06", horario: "22:00", adversario: "Haiti", local: "Lincoln Financial Field, Filadélfia" },
      { data: "24/06", horario: "19:00", adversario: "Escócia", local: "Hard Rock Stadium, Miami" },
    ],
  },
  {
    id: "marrocos",
    nome: "Marrocos",
    flag: "🇲🇦",
    grupo: "C",
    descricao: "A sensação de 2022 tenta repetir a dose com sua excelente defesa.",
    destaques: ["Achraf Hakimi", "Hakim Ziyech"],
    jogos: [
      { data: "12/06", horario: "19:00", adversario: "Brasil", local: "MetLife Stadium, Nova York/NJ" },
      { data: "19/06", horario: "19:00", adversario: "Escócia", local: "Gillette Stadium, Boston" },
      { data: "24/06", horario: "19:00", adversario: "Haiti", local: "Mercedes-Benz Stadium, Atlanta" },
    ],
  },
  {
    id: "haiti",
    nome: "Haiti",
    flag: "🇭🇹",
    grupo: "C",
    descricao: "Surpresa da CONCACAF, volta a um Mundial lutando por visibilidade.",
    destaques: ["Frantzdy Pierrot", "Duckens Nazon"],
    jogos: [
      { data: "12/06", horario: "22:00", adversario: "Escócia", local: "Gillette Stadium, Boston" },
      { data: "19/06", horario: "22:00", adversario: "Brasil", local: "Lincoln Financial Field, Filadélfia" },
      { data: "24/06", horario: "19:00", adversario: "Marrocos", local: "Mercedes-Benz Stadium, Atlanta" },
    ],
  },
  {
    id: "escocia",
    nome: "Escócia",
    flag: "🏴",
    grupo: "C",
    descricao: "Muita intensidade, jogo aéreo e raça britânica.",
    destaques: ["Andrew Robertson", "Scott McTominay"],
    jogos: [
      { data: "12/06", horario: "22:00", adversario: "Haiti", local: "Gillette Stadium, Boston" },
      { data: "19/06", horario: "19:00", adversario: "Marrocos", local: "Gillette Stadium, Boston" },
      { data: "24/06", horario: "19:00", adversario: "Brasil", local: "Hard Rock Stadium, Miami" },
    ],
  },
  {
    id: "estados-unidos",
    nome: "Estados Unidos",
    flag: "🇺🇸",
    grupo: "D",
    descricao: "A anfitriã principal quer provar o avanço de sua geração de ouro.",
    destaques: ["Christian Pulisic", "Weston McKennie"],
    jogos: [
      { data: "12/06", horario: "22:00", adversario: "Paraguai", local: "SoFi Stadium, Los Angeles" },
      { data: "19/06", horario: "16:00", adversario: "Austrália", local: "Lumen Field, Seattle" },
      { data: "25/06", horario: "23:00", adversario: "Suécia", local: "SoFi Stadium, Los Angeles" },
    ],
  },
  {
    id: "paraguai",
    nome: "Paraguai",
    flag: "🇵🇾",
    grupo: "D",
    descricao: "Garra guarani de volta aos Mundiais com nova mentalidade.",
    destaques: ["Miguel Almirón", "Julio Enciso"],
    jogos: [
      { data: "12/06", horario: "22:00", adversario: "EUA", local: "SoFi Stadium, Los Angeles" },
      { data: "19/06", horario: "01:00", adversario: "Suécia", local: "Levi's Stadium, Santa Clara" },
      { data: "25/06", horario: "23:00", adversario: "Austrália", local: "Levi's Stadium, Santa Clara" },
    ],
  },
  {
    id: "australia",
    nome: "Austrália",
    flag: "🇦🇺",
    grupo: "D",
    descricao: "Os Socceroos apostam na disciplina tática para surpreender.",
    destaques: ["Mathew Ryan", "Harry Souttar"],
    jogos: [
      { data: "13/06", horario: "01:00", adversario: "Suécia", local: "BC Place, Vancouver" },
      { data: "19/06", horario: "16:00", adversario: "EUA", local: "Lumen Field, Seattle" },
      { data: "25/06", horario: "23:00", adversario: "Paraguai", local: "Levi's Stadium, Santa Clara" },
    ],
  },
  {
    id: "suecia",
    nome: "Suécia",
    flag: "🇸🇪",
    grupo: "D",
    descricao: "Traz de volta o futebol escandinavo ágil e ofensivo.",
    destaques: ["Alexander Isak", "Dejan Kulusevski"],
    jogos: [
      { data: "13/06", horario: "01:00", adversario: "Austrália", local: "BC Place, Vancouver" },
      { data: "19/06", horario: "01:00", adversario: "Paraguai", local: "Levi's Stadium, Santa Clara" },
      { data: "25/06", horario: "23:00", adversario: "EUA", local: "SoFi Stadium, Los Angeles" },
    ],
  },
  {
    id: "alemanha",
    nome: "Alemanha",
    flag: "🇩🇪",
    grupo: "E",
    descricao: "Quer apagar as últimas campanhas ruins e impor sua tradição.",
    destaques: ["Jamal Musiala", "Florian Wirtz"],
    jogos: [
      { data: "13/06", horario: "14:00", adversario: "Curaçao", local: "NRG Stadium, Houston" },
      { data: "20/06", horario: "17:00", adversario: "Costa do Marfim", local: "Estádio a definir" },
      { data: "25/06", horario: "17:00", adversario: "Equador", local: "MetLife Stadium, Nova York/NJ" },
    ],
  },
  {
    id: "curacao",
    nome: "Curaçao",
    flag: "🇨🇼",
    grupo: "E",
    descricao: "Estreante histórico e a menor nação a se classificar, prometendo carisma.",
    destaques: ["Leandro Bacuna", "Jürgen Locadia"],
    jogos: [
      { data: "13/06", horario: "14:00", adversario: "Alemanha", local: "NRG Stadium, Houston" },
      { data: "20/06", horario: "14:00", adversario: "Equador", local: "Estádio a definir" },
      { data: "25/06", horario: "17:00", adversario: "Costa do Marfim", local: "Lincoln Fin. Field, Filadélfia" },
    ],
  },
  {
    id: "costa-do-marfim",
    nome: "Costa do Marfim",
    flag: "🇨🇮",
    grupo: "E",
    descricao: "Campeã continental recente, volta com força física imponente.",
    destaques: ["Sébastien Haller", "Franck Kessié"],
    jogos: [
      { data: "13/06", horario: "20:00", adversario: "Equador", local: "Lincoln Fin. Field, Filadélfia" },
      { data: "20/06", horario: "17:00", adversario: "Alemanha", local: "Estádio a definir" },
      { data: "25/06", horario: "17:00", adversario: "Curaçao", local: "Lincoln Fin. Field, Filadélfia" },
    ],
  },
  {
    id: "equador",
    nome: "Equador",
    flag: "🇪🇨",
    grupo: "E",
    descricao: "Geração jovem brilhante e muita imposição atlética no meio-campo.",
    destaques: ["Moisés Caicedo", "Piero Hincapié"],
    jogos: [
      { data: "13/06", horario: "20:00", adversario: "Costa do Marfim", local: "Lincoln Fin. Field, Filadélfia" },
      { data: "20/06", horario: "14:00", adversario: "Curaçao", local: "Estádio a definir" },
      { data: "25/06", horario: "17:00", adversario: "Alemanha", local: "MetLife Stadium, Nova York/NJ" },
    ],
  },
  {
    id: "holanda",
    nome: "Holanda",
    flag: "🇳🇱",
    grupo: "F",
    descricao: "Busca o título inédito apostando num esquema defensivo de elite mundial.",
    destaques: ["Virgil van Dijk", "Xavi Simons"],
    jogos: [
      { data: "13/06", horario: "17:00", adversario: "Japão", local: "AT&T Stadium, Dallas" },
      { data: "20/06", horario: "20:00", adversario: "Turquia", local: "Estádio a definir" },
      { data: "25/06", horario: "20:00", adversario: "Tunísia", local: "Arrowhead Stadium, Kansas City" },
    ],
  },
  {
    id: "japao",
    nome: "Japão",
    flag: "🇯🇵",
    grupo: "F",
    descricao: "Intensidade e precisão asiática que já derrubou gigantes em 2022.",
    destaques: ["Takefusa Kubo", "Kaoru Mitoma"],
    jogos: [
      { data: "13/06", horario: "17:00", adversario: "Holanda", local: "AT&T Stadium, Dallas" },
      { data: "21/06", horario: "01:00", adversario: "Tunísia", local: "Estádio BBVA, Monterrey" },
      { data: "25/06", horario: "20:00", adversario: "Turquia", local: "AT&T Stadium, Dallas" },
    ],
  },
  {
    id: "tunisia",
    nome: "Tunísia",
    flag: "🇹🇳",
    grupo: "F",
    descricao: "Organização tática severa para finalmente passar de fase.",
    destaques: ["Ellyes Skhiri", "Aïssa Laïdouni"],
    jogos: [
      { data: "13/06", horario: "23:00", adversario: "Turquia", local: "Estádio BBVA, Monterrey" },
      { data: "21/06", horario: "01:00", adversario: "Japão", local: "Estádio BBVA, Monterrey" },
      { data: "25/06", horario: "20:00", adversario: "Holanda", local: "Arrowhead Stadium, Kansas City" },
    ],
  },
  {
    id: "turquia",
    nome: "Turquia",
    flag: "🇹🇷",
    grupo: "F",
    descricao: "Time passional e jovem, focado em transições explosivas.",
    destaques: ["Hakan Çalhanoğlu", "Arda Güler"],
    jogos: [
      { data: "13/06", horario: "23:00", adversario: "Tunísia", local: "Estádio BBVA, Monterrey" },
      { data: "20/06", horario: "20:00", adversario: "Holanda", local: "Estádio a definir" },
      { data: "25/06", horario: "20:00", adversario: "Japão", local: "AT&T Stadium, Dallas" },
    ],
  },
  {
    id: "belgica",
    nome: "Bélgica",
    flag: "🇧🇪",
    grupo: "G",
    descricao: "Fim definitivo da Geração de Ouro e início de uma nova era de talentos.",
    destaques: ["Kevin De Bruyne", "Jérémy Doku"],
    jogos: [
      { data: "14/06", horario: "16:00", adversario: "Egito", local: "Lumen Field, Seattle" },
      { data: "21/06", horario: "16:00", adversario: "Irã", local: "SoFi Stadium, Los Angeles" },
      { data: "26/06", horario: "00:00", adversario: "Nova Zelândia", local: "BC Place, Vancouver" },
    ],
  },
  {
    id: "egito",
    nome: "Egito",
    flag: "🇪🇬",
    grupo: "G",
    descricao: "Depende da genialidade do seu capitão para surpreender.",
    destaques: ["Mohamed Salah", "Omar Marmoush"],
    jogos: [
      { data: "14/06", horario: "16:00", adversario: "Bélgica", local: "Lumen Field, Seattle" },
      { data: "21/06", horario: "22:00", adversario: "Nova Zelândia", local: "BC Place, Vancouver" },
      { data: "26/06", horario: "00:00", adversario: "Irã", local: "Lumen Field, Seattle" },
    ],
  },
  {
    id: "ira",
    nome: "Irã",
    flag: "🇮🇷",
    grupo: "G",
    descricao: "Experiência, resiliência na defesa e artilheiros perigosos na frente.",
    destaques: ["Mehdi Taremi", "Sardar Azmoun"],
    jogos: [
      { data: "14/06", horario: "22:00", adversario: "Nova Zelândia", local: "SoFi Stadium, Los Angeles" },
      { data: "21/06", horario: "16:00", adversario: "Bélgica", local: "SoFi Stadium, Los Angeles" },
      { data: "26/06", horario: "00:00", adversario: "Egito", local: "Lumen Field, Seattle" },
    ],
  },
  {
    id: "nova-zelandia",
    nome: "Nova Zelândia",
    flag: "🇳🇿",
    grupo: "G",
    descricao: "Única da Oceania; aposta na força de contra-ataque.",
    destaques: ["Chris Wood", "Liberato Cacace"],
    jogos: [
      { data: "14/06", horario: "22:00", adversario: "Irã", local: "SoFi Stadium, Los Angeles" },
      { data: "21/06", horario: "22:00", adversario: "Egito", local: "BC Place, Vancouver" },
      { data: "26/06", horario: "00:00", adversario: "Bélgica", local: "BC Place, Vancouver" },
    ],
  },
  {
    id: "espanha",
    nome: "Espanha",
    flag: "🇪🇸",
    grupo: "H",
    descricao: "Toca a bola e domina adversários com seus prodígios técnicos.",
    destaques: ["Lamine Yamal", "Rodri"],
    jogos: [
      { data: "14/06", horario: "13:00", adversario: "Cabo Verde", local: "Mercedes-Benz Stadium, Atlanta" },
      { data: "21/06", horario: "13:00", adversario: "Arábia Saudita", local: "Mercedes-Benz Stadium, Atlanta" },
      { data: "26/06", horario: "21:00", adversario: "Uruguai", local: "Estádio Akron, Zapopan/Guadalajara" },
    ],
  },
  {
    id: "cabo-verde",
    nome: "Cabo Verde",
    flag: "🇨🇻",
    grupo: "H",
    descricao: "Mais um estreante na Copa, famoso pelo futebol rápido e habilidoso.",
    destaques: ["Ryan Mendes", "Jovane Cabral"],
    jogos: [
      { data: "14/06", horario: "13:00", adversario: "Espanha", local: "Mercedes-Benz Stadium, Atlanta" },
      { data: "21/06", horario: "19:00", adversario: "Uruguai", local: "Hard Rock Stadium, Miami" },
      { data: "26/06", horario: "21:00", adversario: "Arábia Saudita", local: "NRG Stadium, Houston" },
    ],
  },
  {
    id: "arabia-saudita",
    nome: "Arábia Saudita",
    flag: "🇸🇦",
    grupo: "H",
    descricao: "Trazida pelo boom de sua liga nacional, tenta chocar o mundo novamente.",
    destaques: ["Salem Al-Dawsari", "Firas Al-Buraikan"],
    jogos: [
      { data: "14/06", horario: "19:00", adversario: "Uruguai", local: "Hard Rock Stadium, Miami" },
      { data: "21/06", horario: "13:00", adversario: "Espanha", local: "Mercedes-Benz Stadium, Atlanta" },
      { data: "26/06", horario: "21:00", adversario: "Cabo Verde", local: "NRG Stadium, Houston" },
    ],
  },
  {
    id: "uruguai",
    nome: "Uruguai",
    flag: "🇺🇾",
    grupo: "H",
    descricao: "Raça e velocidade sob o comando de El Loco Bielsa.",
    destaques: ["Federico Valverde", "Darwin Núñez"],
    jogos: [
      { data: "14/06", horario: "19:00", adversario: "Arábia Saudita", local: "Hard Rock Stadium, Miami" },
      { data: "21/06", horario: "19:00", adversario: "Cabo Verde", local: "Hard Rock Stadium, Miami" },
      { data: "26/06", horario: "21:00", adversario: "Espanha", local: "Estádio Akron, Zapopan/Guadalajara" },
    ],
  },
  {
    id: "franca",
    nome: "França",
    flag: "🇫🇷",
    grupo: "I",
    descricao: "Favorita ao título, equipe recheada de estrelas globais e profundidade de elenco.",
    destaques: ["Kylian Mbappé", "Antoine Griezmann"],
    jogos: [
      { data: "15/06", horario: "18:00", adversario: "RD Congo", local: "Lincoln Fin. Field, Filadélfia" },
      { data: "22/06", horario: "21:00", adversario: "Senegal", local: "Estádio a definir" },
      { data: "26/06", horario: "16:00", adversario: "Noruega", local: "Gillette Stadium, Boston" },
    ],
  },
  {
    id: "senegal",
    nome: "Senegal",
    flag: "🇸🇳",
    grupo: "I",
    descricao: "A potência africana tenta quebrar a barreira do quase.",
    destaques: ["Sadio Mané", "Kalidou Koulibaly"],
    jogos: [
      { data: "15/06", horario: "21:00", adversario: "Noruega", local: "MetLife Stadium, Nova York/NJ" },
      { data: "22/06", horario: "21:00", adversario: "França", local: "Estádio a definir" },
      { data: "26/06", horario: "16:00", adversario: "RD Congo", local: "BMO Field, Toronto" },
    ],
  },
  {
    id: "noruega",
    nome: "Noruega",
    flag: "🇳🇴",
    grupo: "I",
    descricao: "Estreia do cometa Haaland num Mundial, time puramente vertical.",
    destaques: ["Erling Haaland", "Martin Ødegaard"],
    jogos: [
      { data: "15/06", horario: "21:00", adversario: "Senegal", local: "MetLife Stadium, Nova York/NJ" },
      { data: "22/06", horario: "18:00", adversario: "RD Congo", local: "Estádio a definir" },
      { data: "26/06", horario: "16:00", adversario: "França", local: "Gillette Stadium, Boston" },
    ],
  },
  {
    id: "rd-congo",
    nome: "RD Congo",
    flag: "🇨🇩",
    grupo: "I",
    descricao: "Traz físico e jogadores experientes que atuam nas grandes ligas.",
    destaques: ["Chancel Mbemba", "Yoane Wissa"],
    jogos: [
      { data: "15/06", horario: "18:00", adversario: "França", local: "Lincoln Fin. Field, Filadélfia" },
      { data: "22/06", horario: "18:00", adversario: "Noruega", local: "Estádio a definir" },
      { data: "26/06", horario: "16:00", adversario: "Senegal", local: "BMO Field, Toronto" },
    ],
  },
  {
    id: "argentina",
    nome: "Argentina",
    flag: "🇦🇷",
    grupo: "J",
    descricao: "A atual campeã do mundo tenta manter a coroa em sua provável Última Dança de veteranos.",
    destaques: ["Lionel Messi", "Julián Álvarez", "Dibu Martínez"],
    jogos: [
      { data: "16/06", horario: "18:00", adversario: "Argélia", local: "Estádio a definir" },
      { data: "23/06", horario: "20:00", adversario: "Áustria", local: "Estádio a definir" },
      { data: "27/06", horario: "23:00", adversario: "Jordânia", local: "AT&T Stadium, Dallas" },
    ],
  },
  {
    id: "argelia",
    nome: "Argélia",
    flag: "🇩🇿",
    grupo: "J",
    descricao: "Equipe super técnica do norte africano buscando redenção.",
    destaques: ["Riyad Mahrez", "Ismaël Bennacer"],
    jogos: [
      { data: "16/06", horario: "18:00", adversario: "Argentina", local: "Estádio a definir" },
      { data: "23/06", horario: "00:00", adversario: "Jordânia", local: "Levi's Stadium, Santa Clara" },
      { data: "27/06", horario: "23:00", adversario: "Áustria", local: "Arrowhead Stadium, Kansas City" },
    ],
  },
  {
    id: "austria",
    nome: "Áustria",
    flag: "🇦🇹",
    grupo: "J",
    descricao: "Joga no estilo de pressão implacável de Gegenpressing.",
    destaques: ["David Alaba", "Marcel Sabitzer"],
    jogos: [
      { data: "16/06", horario: "01:00", adversario: "Jordânia", local: "Levi's Stadium, Santa Clara" },
      { data: "23/06", horario: "20:00", adversario: "Argentina", local: "Estádio a definir" },
      { data: "27/06", horario: "23:00", adversario: "Argélia", local: "Arrowhead Stadium, Kansas City" },
    ],
  },
  {
    id: "jordania",
    nome: "Jordânia",
    flag: "🇯🇴",
    grupo: "J",
    descricao: "Estreante histórico após excelente ciclo continental.",
    destaques: ["Musa Al-Taamari", "Yazan Al-Naimat"],
    jogos: [
      { data: "16/06", horario: "01:00", adversario: "Áustria", local: "Levi's Stadium, Santa Clara" },
      { data: "23/06", horario: "00:00", adversario: "Argélia", local: "Levi's Stadium, Santa Clara" },
      { data: "27/06", horario: "23:00", adversario: "Argentina", local: "AT&T Stadium, Dallas" },
    ],
  },
  {
    id: "portugal",
    nome: "Portugal",
    flag: "🇵🇹",
    grupo: "K",
    descricao: "Equilíbrio de jovens lendas e veteranos para tentar um título histórico.",
    destaques: ["Cristiano Ronaldo", "Bruno Fernandes"],
    jogos: [
      { data: "16/06", horario: "14:00", adversario: "Iraque", local: "NRG Stadium, Houston" },
      { data: "23/06", horario: "14:00", adversario: "Uzbequistão", local: "NRG Stadium, Houston" },
      { data: "27/06", horario: "20:30", adversario: "Colômbia", local: "Hard Rock Stadium, Miami" },
    ],
  },
  {
    id: "uzbequistao",
    nome: "Uzbequistão",
    flag: "🇺🇿",
    grupo: "K",
    descricao: "Outra grande estreia; lobos asiáticos com boa compactação tática.",
    destaques: ["Eldor Shomurodov", "Abbosbek Fayzullaev"],
    jogos: [
      { data: "16/06", horario: "23:00", adversario: "Colômbia", local: "Estádio Azteca, Cidade do México" },
      { data: "23/06", horario: "14:00", adversario: "Portugal", local: "NRG Stadium, Houston" },
      { data: "27/06", horario: "20:30", adversario: "Iraque", local: "Mercedes-Benz Stadium, Atlanta" },
    ],
  },
  {
    id: "colombia",
    nome: "Colômbia",
    flag: "🇨🇴",
    grupo: "K",
    descricao: "Futebol bonito, leve e letal no ataque, uma ameaça imensa.",
    destaques: ["Luis Díaz", "James Rodríguez"],
    jogos: [
      { data: "16/06", horario: "23:00", adversario: "Uzbequistão", local: "Estádio Azteca, Cidade do México" },
      { data: "23/06", horario: "23:00", adversario: "Iraque", local: "Estádio Akron, Zapopan/Guadalajara" },
      { data: "27/06", horario: "20:30", adversario: "Portugal", local: "Hard Rock Stadium, Miami" },
    ],
  },
  {
    id: "iraque",
    nome: "Iraque",
    flag: "🇮🇶",
    grupo: "K",
    descricao: "De volta ao Mundial focada em jogo aéreo e paixão tática.",
    destaques: ["Aymen Hussein", "Ali Jasim"],
    jogos: [
      { data: "16/06", horario: "14:00", adversario: "Portugal", local: "NRG Stadium, Houston" },
      { data: "23/06", horario: "23:00", adversario: "Colômbia", local: "Estádio Akron, Zapopan/Guadalajara" },
      { data: "27/06", horario: "20:30", adversario: "Uzbequistão", local: "Mercedes-Benz Stadium, Atlanta" },
    ],
  },
  {
    id: "inglaterra",
    nome: "Inglaterra",
    flag: "🏴",
    grupo: "L",
    descricao: "Um dos elencos mais caros do mundo sedento por findar o jejum histórico.",
    destaques: ["Jude Bellingham", "Harry Kane"],
    jogos: [
      { data: "16/06", horario: "17:00", adversario: "Croácia", local: "AT&T Stadium, Dallas" },
      { data: "23/06", horario: "17:00", adversario: "Gana", local: "Gillette Stadium, Boston" },
      { data: "27/06", horario: "18:00", adversario: "Panamá", local: "Estádio a definir" },
    ],
  },
  {
    id: "croacia",
    nome: "Croácia",
    flag: "🇭🇷",
    grupo: "L",
    descricao: "O último brilho de uma das gerações mais consistentes das Copas.",
    destaques: ["Luka Modrić", "Joško Gvardiol"],
    jogos: [
      { data: "16/06", horario: "17:00", adversario: "Inglaterra", local: "AT&T Stadium, Dallas" },
      { data: "23/06", horario: "20:00", adversario: "Panamá", local: "BMO Field, Toronto" },
      { data: "27/06", horario: "18:00", adversario: "Gana", local: "Lincoln Fin. Field, Filadélfia" },
    ],
  },
  {
    id: "gana",
    nome: "Gana",
    flag: "🇬🇭",
    grupo: "L",
    descricao: "Físico invejável e muita irreverência no último terço de campo.",
    destaques: ["Mohammed Kudus", "Iñaki Williams"],
    jogos: [
      { data: "16/06", horario: "20:00", adversario: "Panamá", local: "BMO Field, Toronto" },
      { data: "23/06", horario: "17:00", adversario: "Inglaterra", local: "Gillette Stadium, Boston" },
      { data: "27/06", horario: "18:00", adversario: "Croácia", local: "Lincoln Fin. Field, Filadélfia" },
    ],
  },
  {
    id: "panama",
    nome: "Panamá",
    flag: "🇵🇦",
    grupo: "L",
    descricao: "Representante vibrante da CONCACAF pronto para atrapalhar gigantes.",
    destaques: ["Adalberto Carrasquilla", "Michael Amir Murillo"],
    jogos: [
      { data: "16/06", horario: "20:00", adversario: "Gana", local: "BMO Field, Toronto" },
      { data: "23/06", horario: "20:00", adversario: "Croácia", local: "BMO Field, Toronto" },
      { data: "27/06", horario: "18:00", adversario: "Inglaterra", local: "Estádio a definir" },
    ],
  },
];

const groups = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L"];
const storageKey = "worldcup-2026-followed-teams";

export default function HomePage() {
  const [activeTab, setActiveTab] = useState("all");
  const [followedIds, setFollowedIds] = useState([]);
  const [selectedTeamId, setSelectedTeamId] = useState(null);
  const [isStorageLoaded, setIsStorageLoaded] = useState(false);

  // Carrega os times seguidos uma vez, quando o componente abre no navegador.
  useEffect(() => {
    const savedTeams = JSON.parse(localStorage.getItem(storageKey) || "[]");
    setFollowedIds(savedTeams);
    setIsStorageLoaded(true);
  }, []);

  // Salva no LocalStorage sempre que o usuário segue ou remove uma seleção.
  useEffect(() => {
    if (isStorageLoaded) {
      localStorage.setItem(storageKey, JSON.stringify(followedIds));
    }
  }, [followedIds, isStorageLoaded]);

  const followedTeams = useMemo(
    () => worldCupTeams.filter((team) => followedIds.includes(team.id)),
    [followedIds],
  );

  const teamsByGroup = useMemo(
    () =>
      groups.map((group) => ({
        group,
        teams: worldCupTeams.filter((team) => team.grupo === group),
      })),
    [],
  );

  function toggleFollow(teamId) {
    setFollowedIds((currentIds) => {
      if (currentIds.includes(teamId)) {
        return currentIds.filter((id) => id !== teamId);
      }

      return [...currentIds, teamId];
    });

    if (selectedTeamId === teamId) {
      setSelectedTeamId(null);
    }
  }

  return (
    <main className="mx-auto flex min-h-screen w-full max-w-6xl flex-col px-4 pb-28 pt-5 sm:px-6 lg:px-8">
      <Header followedCount={followedTeams.length} />

      {activeTab === "all" ? (
        <AllTeamsTab teamsByGroup={teamsByGroup} followedIds={followedIds} onToggleFollow={toggleFollow} />
      ) : (
        <MyTeamsTab
          teams={followedTeams}
          selectedTeamId={selectedTeamId}
          onSelectTeam={setSelectedTeamId}
          onToggleFollow={toggleFollow}
          onGoToAllTeams={() => setActiveTab("all")}
        />
      )}

      <BottomNavigation activeTab={activeTab} onChangeTab={setActiveTab} followedCount={followedTeams.length} />
    </main>
  );
}

function Header({ followedCount }) {
  return (
    <header className="mb-5 border-b border-white/10 pb-5">
      <div className="mb-4 flex items-start justify-between gap-4">
        <div>
          <p className="mb-2 flex items-center gap-2 text-xs font-semibold uppercase tracking-[0.2em] text-cup-green">
            <Trophy className="h-4 w-4" />
            Copa do Mundo 2026
          </p>
          <h1 className="text-3xl font-black leading-tight text-white">Meu Guia da Copa</h1>
        </div>

        <div className="rounded-lg border border-cup-blue/30 bg-cup-blue/10 px-3 py-2 text-center">
          <strong className="block text-2xl text-cup-blue">{followedCount}</strong>
          <span className="text-[11px] font-medium text-slate-300">seguidos</span>
        </div>
      </div>

      <p className="text-sm font-medium text-slate-300">48 seleções · 12 grupos · fase de grupos</p>
    </header>
  );
}

function AllTeamsTab({ teamsByGroup, followedIds, onToggleFollow }) {
  return (
    <section className="space-y-6">
      <div className="flex items-center justify-between gap-3">
        <div>
          <h2 className="text-xl font-bold text-white">Todos os Times</h2>
          <p className="text-sm text-slate-400">Grupos A ao L · 4 seleções por grupo</p>
        </div>
        <div className="rounded-lg border border-cup-green/30 bg-cup-green/10 px-3 py-2 text-right">
          <strong className="block text-sm text-cup-green">48</strong>
          <span className="text-[11px] text-slate-400">times</span>
        </div>
      </div>

      {teamsByGroup.map(({ group, teams }) => (
        <section key={group} className="space-y-3">
          <div className="flex items-center gap-3">
            <span className="flex h-9 w-9 items-center justify-center rounded-lg bg-cup-blue text-sm font-black text-cup-dark">
              {group}
            </span>
            <div>
              <h3 className="font-bold text-white">Grupo {group}</h3>
              <p className="text-xs text-slate-400">{teams.length} seleções</p>
            </div>
          </div>

          <div className="grid grid-cols-1 gap-3 sm:grid-cols-2 lg:grid-cols-4">
            {teams.map((team) => (
              <TeamCard
                key={team.id}
                team={team}
                isFollowed={followedIds.includes(team.id)}
                onToggleFollow={onToggleFollow}
              />
            ))}
          </div>
        </section>
      ))}
    </section>
  );
}

function TeamCard({ team, isFollowed, onToggleFollow }) {
  return (
    <article
      className={`rounded-lg border p-4 transition ${
        isFollowed
          ? "border-cup-green/60 bg-cup-green/10 shadow-lg shadow-cup-green/10"
          : "border-white/10 bg-white/[0.06]"
      }`}
    >
      <div className="mb-4 flex items-start justify-between gap-3">
        <div className="flex min-w-0 items-center gap-3">
          <span className="text-3xl leading-none">{team.flag}</span>
          <div className="min-w-0">
            <h4 className="truncate font-bold text-white">{team.nome}</h4>
            <p className="text-xs font-medium text-slate-400">Grupo {team.grupo}</p>
          </div>
        </div>

        {isFollowed && <Star className="h-5 w-5 flex-none fill-cup-green text-cup-green" />}
      </div>

      <button
        type="button"
        onClick={() => onToggleFollow(team.id)}
        className={`flex w-full items-center justify-center gap-2 rounded-lg px-4 py-3 text-sm font-bold transition ${
          isFollowed
            ? "bg-white/10 text-cup-green hover:bg-white/15"
            : "bg-cup-blue text-cup-dark hover:bg-cup-green"
        }`}
        aria-label={isFollowed ? `Remover ${team.nome} dos meus times` : `Seguir ${team.nome}`}
      >
        <Heart className={`h-4 w-4 ${isFollowed ? "fill-cup-green" : ""}`} />
        {isFollowed ? "Seguindo" : "Seguir"}
      </button>
    </article>
  );
}

function MyTeamsTab({ teams, selectedTeamId, onSelectTeam, onToggleFollow, onGoToAllTeams }) {
  if (teams.length === 0) {
    return (
      <section className="flex flex-1 items-center justify-center py-10">
        <div className="rounded-lg border border-white/10 bg-white/[0.06] p-6 text-center">
          <div className="mx-auto mb-4 flex h-14 w-14 items-center justify-center rounded-full bg-cup-green/15 text-cup-green">
            <Sparkles className="h-7 w-7" />
          </div>
          <h2 className="mb-2 text-xl font-bold text-white">Nenhum time seguido</h2>
          <p className="mb-5 text-sm leading-6 text-slate-400">
            Sua lista de seleções favoritas ainda está vazia.
          </p>
          <button
            type="button"
            onClick={onGoToAllTeams}
            className="rounded-lg bg-cup-green px-5 py-3 text-sm font-bold text-cup-dark"
          >
            Escolher Times
          </button>
        </div>
      </section>
    );
  }

  return (
    <section className="space-y-4">
      <div>
        <h2 className="text-xl font-bold text-white">Meus Times</h2>
        <p className="text-sm text-slate-400">{teams.length} seleções seguidas</p>
      </div>

      <div className="space-y-3">
        {teams.map((team) => (
          <FavoriteTeamCard
            key={team.id}
            team={team}
            isOpen={selectedTeamId === team.id}
            onSelectTeam={onSelectTeam}
            onToggleFollow={onToggleFollow}
          />
        ))}
      </div>
    </section>
  );
}

function FavoriteTeamCard({ team, isOpen, onSelectTeam, onToggleFollow }) {
  return (
    <article className="overflow-hidden rounded-lg border border-white/10 bg-white/[0.06]">
      <button
        type="button"
        onClick={() => onSelectTeam(isOpen ? null : team.id)}
        className="flex w-full items-center justify-between gap-3 p-4 text-left"
      >
        <div className="flex min-w-0 items-center gap-3">
          <span className="text-4xl leading-none">{team.flag}</span>
          <div className="min-w-0">
            <h3 className="truncate text-lg font-black text-white">{team.nome}</h3>
            <p className="text-sm text-slate-400">Grupo {team.grupo}</p>
          </div>
        </div>

        <ChevronDown className={`h-5 w-5 flex-none text-cup-blue transition ${isOpen ? "rotate-180" : ""}`} />
      </button>

      {isOpen && (
        <div className="border-t border-white/10 px-4 pb-4 pt-1">
          <p className="mb-4 text-sm leading-6 text-slate-300">{team.descricao}</p>

          <div className="mb-4 border-l-2 border-cup-blue/60 pl-3">
            <p className="mb-2 flex items-center gap-2 text-xs font-bold uppercase tracking-[0.16em] text-cup-blue">
              <Users className="h-4 w-4" />
              Destaques
            </p>
            <div className="flex flex-wrap gap-2">
              {team.destaques.map((player) => (
                <span key={player} className="rounded-full bg-white/10 px-3 py-1 text-sm font-semibold text-white">
                  {player}
                </span>
              ))}
            </div>
          </div>

          <div className="space-y-3">
            <p className="flex items-center gap-2 text-xs font-bold uppercase tracking-[0.16em] text-cup-green">
              <CalendarDays className="h-4 w-4" />
              Jogos da fase de grupos
            </p>

            {team.jogos.map((jogo) => (
              <MatchCard key={`${team.id}-${jogo.data}-${jogo.adversario}`} jogo={jogo} />
            ))}
          </div>

          <button
            type="button"
            onClick={() => onToggleFollow(team.id)}
            className="mt-4 flex w-full items-center justify-center gap-2 rounded-lg border border-red-400/30 bg-red-500/10 px-4 py-3 text-sm font-bold text-red-200"
          >
            <Heart className="h-4 w-4 fill-red-200" />
            Remover dos meus times
          </button>
        </div>
      )}
    </article>
  );
}

function MatchCard({ jogo }) {
  return (
    <div className="border-t border-white/10 py-3">
      <div className="mb-2 flex items-center justify-between gap-3">
        <strong className="text-white">x {jogo.adversario}</strong>
        <span className="rounded-full bg-cup-green/15 px-3 py-1 text-xs font-bold text-cup-green">{jogo.data}</span>
      </div>

      <div className="space-y-2 text-sm text-slate-300">
        <p className="flex items-center gap-2">
          <Clock className="h-4 w-4 text-cup-blue" />
          {jogo.horario}
        </p>
        <p className="flex items-start gap-2">
          <MapPin className="mt-0.5 h-4 w-4 flex-none text-cup-blue" />
          {jogo.local}
        </p>
      </div>
    </div>
  );
}

function BottomNavigation({ activeTab, onChangeTab, followedCount }) {
  return (
    <nav className="fixed inset-x-0 bottom-0 z-50 border-t border-white/10 bg-cup-dark/95 px-4 pb-4 pt-3 backdrop-blur">
      <div className="mx-auto grid max-w-md grid-cols-2 gap-3">
        <TabButton
          label="Todos os Times"
          icon={Trophy}
          isActive={activeTab === "all"}
          onClick={() => onChangeTab("all")}
        />
        <TabButton
          label="Meus Times"
          icon={Star}
          isActive={activeTab === "mine"}
          onClick={() => onChangeTab("mine")}
          badge={followedCount}
        />
      </div>
    </nav>
  );
}

function TabButton({ label, icon: Icon, isActive, onClick, badge }) {
  return (
    <button
      type="button"
      onClick={onClick}
      className={`relative flex items-center justify-center gap-2 rounded-lg px-3 py-3 text-sm font-bold transition ${
        isActive ? "bg-cup-green text-cup-dark" : "bg-white/10 text-slate-300"
      }`}
    >
      <Icon className="h-5 w-5" />
      <span>{label}</span>
      {badge > 0 && (
        <span className="absolute -right-1 -top-1 flex h-5 min-w-[1.25rem] items-center justify-center rounded-full bg-cup-blue px-1 text-[11px] font-black text-cup-dark">
          {badge}
        </span>
      )}
    </button>
  );
}
