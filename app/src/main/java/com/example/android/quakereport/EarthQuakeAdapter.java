package com.example.android.quakereport;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import android.graphics.drawable.GradientDrawable;


public class EarthQuakeAdapter extends ArrayAdapter<EarthQuake> {
    private static final String LOG_TAG = EarthQuakeAdapter.class.getSimpleName();

    /**
     * Constructs a new {@link EarthQuakeAdapter}.
     *
     * @param context of the app
     * @param earthQuakes is the list of earthquakes, which is the data source of the adapter
     */
    public EarthQuakeAdapter(Activity context, ArrayList<EarthQuake> earthQuakes){
        super(context, 0, earthQuakes);
    }


    /**
     * Returns a list item vizw that displays information about the earthquake at the given position
     * in the list of earthquakes
     */
    @Override
    public View getView(int position, View convertView,   ViewGroup parent) {
        // Checks if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, the inflate a new list item layout.
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Find the earthquake at the given position in the list of earthquakes
        EarthQuake earthQuake = getItem(position);



        // Find the TextView in the list_item.xml layout with ID mag_textView
        TextView magTextview = convertView.findViewById(R.id.mag_textview);

        GradientDrawable magnitudeCircle = (GradientDrawable) magTextview.getBackground();
        int magnitudeColor = getMagnitudeColor(earthQuake.getMagnitude());

        magnitudeCircle.setColor(magnitudeColor);
                //Get the magnitude from the current EarthQuake object and
        // Set this text on the mag TextView
        DecimalFormat formater = new DecimalFormat("0.0");
        String mag = formater.format(earthQuake.getMagnitude());
        magTextview.setText(String.format("%s", mag));

        String location = earthQuake.getEarthPlace();
        int index = location.indexOf("of");


        // Find the TextView in the list_item.xml layout with ID place_textView
        TextView distanceTextview = convertView.findViewById(R.id.distance_textview);
        //Get the Place from the current EarthQuake object and
        // Set this text on the place TextView
        String val = index > 0 ? location.substring(0, index+2): "Near the";
        distanceTextview.setText(String.format("%s", val));

        // Find the TextView in the list_item.xml layout with ID place_textView
        TextView placeTextview = convertView.findViewById(R.id.place_textview);
        //Get the Place from the current EarthQuake object and
        // Set this text on the place TextView

        val = index > 0 ? location.substring(index+3): location;
        placeTextview.setText(String.format("%s", val));

        Date dateObject = new Date(earthQuake.getEarthDate());

        // Find the TextView in the list_item.xml layout with ID date_textView
        TextView dateTextview = convertView.findViewById(R.id.date_textview);
        //Get the Date from the current EarthQuake object and
        // Set this text on the date TextView
        dateTextview.setText(String.format("%s", formatDate(dateObject) ));


        // Find the TextView in the list_item.xml layout with ID date_textView
        TextView timeTextview = convertView.findViewById(R.id.time_textview);
        //Get the Date from the current EarthQuake object and
        // Set this text on the date TextView
        timeTextview.setText(String.format("%s", formatTime(dateObject)));


        // Return the list item view that is now showing the appropriate data
        return convertView;
    }

    private String formatDate(Date dateObject){
        SimpleDateFormat dateFormater = new SimpleDateFormat("MMM DD, yyyy");
        return dateFormater.format(dateObject);
    }


    private String formatTime(Date dateObject){
        SimpleDateFormat timeFormater = new SimpleDateFormat("h:mm a");
        return timeFormater.format(dateObject);
    }

    private int getMagnitudeColor(double magnitude){
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor){
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
