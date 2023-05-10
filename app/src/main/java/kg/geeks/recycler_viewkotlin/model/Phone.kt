package kg.geeks.recycler_viewkotlin.model

import android.media.Image
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Phone (
    val image: String? = "No photo found",
    val brand: String? = "Unknown description",
    val price: Int? = 0,
    val description: String? = "Unknown description"
        ) : Parcelable