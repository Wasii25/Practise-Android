package com.example.amphibiansapp.fake

import com.example.amphibiansapp.model.Amphibian


object FakeDataSource {
    const val frogName = "Frog"
    const val salamanderName = "Salamander"
    const val frogImage = "https://example.com/frog.jpg"
    const val salamanderImage = "https://example.com/salamander.jpg"

    val amphibiansList = listOf(
        Amphibian(
            name = frogName,
            type = "Rainforest",
            description = "A small green frog that thrives in damp environments.",
            imgSrc = frogImage
        ),
        Amphibian(
            name = salamanderName,
            type = "Mountain",
            description = "A long-tailed amphibian known for its ability to regrow limbs.",
            imgSrc = salamanderImage
        )
    )
}