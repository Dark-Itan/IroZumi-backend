package com.irozumi.core.security

object BadWordsFilter {
    private val badWords = setOf(
        // Chingar y derivados
        "chingar", "chinga", "chingado", "chingados", "chingada", "chingadera",
        "chingón", "chingona", "chingaquedito", "chingue", "chingues",
        "chinguen", "chingamos", "chingas", "chingan",
        // Puto/Puta
        "puto", "puta", "putos", "putas", "putito", "putita",
        // Verga
        "verga", "vergas", "vergueada", "verguiza",
        // Cabrón
        "cabron", "cabrona", "cabrones", "cabronas", "cabronada",
        // Pendejo
        "pendejo", "pendeja", "pendejos", "pendejas", "pendejada", "pendejear", "pendejez",
        // Culero
        "culero", "culera", "culeros", "culeras", "culada",
        // Mamar/Mamón
        "mamar", "mamón", "mamona", "mamones", "mamonas",
        // Joder
        "joder", "jodido", "jodida", "jodidos", "jodidas",
        // Mierda
        "mierda", "mierdas", "mierdero",
        // Pinche
        "pinche", "pinches", "pinchis",
        // Carajo
        "carajo", "carajos", "carajito",
        // Huevón
        "huevon", "huevona", "huevones", "huevonas", "huevazos",
        // Perro/Perra
        "perra", "perro", "perras", "perros", "perrita", "perrito",
        // Pito
        "pito", "pitos", "pitito",
        // Nalgas
        "nalgas", "nalga", "nalgón", "nalgona",
        // Cagar
        "cagar", "cagada", "cagado", "cagadas", "cagadero",
        // Pedo
        "pedo", "pedos", "pedote", "pedito",
        // Culo
        "culo", "culos", "culito",
        // Otros
        "baboso", "babosa", "babosos", "babosadas",
        "hocicon", "hocicona", "hocicones",
        "metiche", "metiches",
        "arguendero", "arguendera",
        "gacho", "gacha", "gachos",
        "ojete", "ojetes", "ojetudo",
        "concha", "conchas",
        "malparido", "malparida", "malparidos",
        "idiota", "idiotas",
        "imbecil", "imbeciles",
        "estupido", "estupida", "estupidos", "estupidas",
        "guerco", "guercos", "guerca",
        "chichi", "chichis",
        "huevos"
    )

    fun isToxic(text: String): Boolean {
        val lowerText = text.lowercase().replace(" ", "")
        return badWords.any { badWord ->
            lowerText.contains(badWord)
        }
    }
}