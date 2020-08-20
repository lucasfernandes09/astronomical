package com.example.teste_kt

import android.os.Parcel
import android.os.Parcelable

class Planeta(val nome: String?) : Parcelable {

    var diametro: String? = null
    var massa: String? = null
    var distanciaSol: String? = null
    var anoTerrestre: String? = null
    var diaTerrestre: String? = null
    var img: Int = 0
    var icon: Int = 0

    constructor(parcel: Parcel) : this(parcel.readString()) {
        diametro = parcel.readString()
        massa = parcel.readString()
        distanciaSol = parcel.readString()
        anoTerrestre = parcel.readString()
        diaTerrestre = parcel.readString()
    }

    init {
        when(nome) {
            "Mercúrio" -> { diametro = "4878 Km"; massa = "0.05"; distanciaSol = "57.900.000 Km"; anoTerrestre = "87.9 dias"; diaTerrestre = "58 dias";
                img = R.drawable.jpg_1; icon = R.drawable.ic_p_mercury}
            "Vênus" -> {diametro = "12.100 Km"; massa = "0.815"; distanciaSol = "108.200.000 Km"; anoTerrestre = "224 dias"; diaTerrestre = "-234 dias";
                img = R.drawable.jpg_2; icon = R.drawable.ic_p_venus}
            "Terra" -> {diametro = "12.756 Km"; massa = "1"; distanciaSol = "149.700.000 Km"; anoTerrestre = "365 dias"; diaTerrestre = "24h";
                img = R.drawable.jpg_3; icon = R.drawable.ic_p_earth}
            "Marte" -> {diametro = "6.786 Km"; massa = "0.1"; distanciaSol = "227.900.000 Km"; anoTerrestre = "687 dias"; diaTerrestre = "24h 37m";
                img = R.drawable.jpg_4; icon = R.drawable.ic_p_mars}
            "Júpiter" -> {diametro = "142.984 Km"; massa = "317.9"; distanciaSol = "778.400.000 Km"; anoTerrestre = "11.86 anos"; diaTerrestre = "9h 48m";
                img = R.drawable.jpg_5; icon = R.drawable.ic_p_jupiter}
            "Saturno" -> {diametro = "120.536 Km"; massa = "95"; distanciaSol = "1.423.600.000 Km"; anoTerrestre = "29.46 anos"; diaTerrestre = "10h 12m";
                img = R.drawable.jpg_6; icon = R.drawable.ic_p_saturn}
            "Urano" -> {diametro = "51.108 Km"; massa = "14.6"; distanciaSol = "2.867.000.000 Km"; anoTerrestre = "84.04 anos"; diaTerrestre = "-17h 54m";
                img = R.drawable.jpg_7; icon = R.drawable.ic_p_uranus}
            "Netuno" -> {diametro = "49.538 Km"; massa = "17.2"; distanciaSol = "4.488.000.000 Km"; anoTerrestre = "164 anos"; diaTerrestre = "19h 6m";
                img = R.drawable.jpg_8; icon = R.drawable.ic_p_neptune}
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nome)
        parcel.writeString(diametro)
        parcel.writeString(massa)
        parcel.writeString(distanciaSol)
        parcel.writeString(anoTerrestre)
        parcel.writeString(diaTerrestre)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Planeta> {
        override fun createFromParcel(parcel: Parcel): Planeta {
            return Planeta(parcel)
        }

        override fun newArray(size: Int): Array<Planeta?> {
            return arrayOfNulls(size)
        }
    }

}