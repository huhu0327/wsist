package com.huhu.wsist.fragment

import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.huhu.wsist.MainActivity
import com.huhu.wsist.R
import net.daum.mf.map.api.MapView

class MapFragment : Fragment() {

    private lateinit var mapView: MapView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_map, container, false)

        val activity = (activity as MainActivity)
        activity.changeActionBarTitle("지도")

        mapView = view.findViewById<MapView>(R.id.map_view).apply {
            isHDMapTileEnabled = true
            // 내위치 마커 표시및 위치 이동
            currentLocationTrackingMode = MapView.CurrentLocationTrackingMode.TrackingModeOnWithoutHeading
            // 내위치 마커만 표시
            //currentLocationTrackingMode = MapView.CurrentLocationTrackingMode.TrackingModeOnWithoutHeadingWithoutMapMoving
        }

        view.findViewById<FloatingActionButton>(R.id.map_location).setOnClickListener {
            moveCurrentLocation()
        }

        return view
    }

    private fun moveCurrentLocation() {
        val lm = (activity as MainActivity).getSystemService(Context.LOCATION_SERVICE) as LocationManager

//        lm.requestLocationUpdates("GPS_PROVIDER", 1000, 1f, locationCallback)
//        lm.requestLocationUpdates("NETWORK_PROVIDER", 1000, 1f, locationCallback)
    }

    private val locationCallback = object : LocationListener {
        override fun onLocationChanged(location: Location?) {

        }

        override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
        }

        override fun onProviderEnabled(provider: String?) {
        }

        override fun onProviderDisabled(provider: String?) {
        }
    }
}

