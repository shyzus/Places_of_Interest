package nl.hva.fdmci.mobiledevelopment.placesofinterest

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import nl.hva.fdmci.mobiledevelopment.placesofinterest.model.Place
import nl.hva.fdmci.mobiledevelopment.placesofinterest.model.PlaceAdapter

class MainActivity : AppCompatActivity() {

    var places: ArrayList<Place> = arrayListOf()
    var placeAdapter: PlaceAdapter = PlaceAdapter(places)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        initViews()
    }

    fun initViews() {
        rvPlaces.adapter = placeAdapter
        rvPlaces.layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        for (i in Place.PLACE_NAMES.indices) {
            places.add(Place(Place.PLACE_NAMES[i], Place.PLACE_RES_DRAWABLE_IDS[i]))
        }
        placeAdapter.notifyDataSetChanged()

    }

}
