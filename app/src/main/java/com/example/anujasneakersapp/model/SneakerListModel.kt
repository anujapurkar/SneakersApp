package com.example.anujasneakersapp.model

data class SneakerListModel(
    var id: String? = null,
    var brand: String? = null,
    var colorway: String? = null,
    var gender: String? = null,
    var media: MediaModel? = MediaModel(),
    var releaseDate: String? = null,
    var retailPrice: Int? = null,
    var styleId: String? = null,
    var shoe: String? = null,
    var name: String? = null
)
