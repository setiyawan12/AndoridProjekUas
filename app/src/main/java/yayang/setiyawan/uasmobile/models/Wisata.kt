package yayang.setiyawan.uasmobile.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Wisata(
    @SerializedName("id") var id : String? = null,
    @SerializedName("name") var name : String? = null,
    @SerializedName("location") var location: String? = null,
    @SerializedName("description") var description : String? = null,
): Parcelable