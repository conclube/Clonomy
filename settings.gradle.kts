rootProject.name = "Clonomy"

include(
    ":module-api",
    ":module-bukkit",
    ":module-shared",
    ":module-annotations"
)

rename(
    ":module-api" to "api",
    ":module-bukkit" to "bukkit",
    ":module-shared" to "shared",
    ":module-annotations" to "annotations"
)

fun rename(path: String, newName: String) {
    findProject(path)?.name = newName
}

fun rename(vararg pairs: Pair<String,String>) {
    pairs.forEach {
        rename(it.first,it.second)
    }
}