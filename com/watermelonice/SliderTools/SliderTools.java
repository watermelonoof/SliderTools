package com.watermelonice.SliderTools;

import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.runtime.*;
import com.google.appinventor.components.common.ComponentCategory;

import android.widget.SeekBar;

import java.util.Hashtable;

@DesignerComponent(version = 1,
                   versionName = "v1.0",
                   helpUrl = "",
                   description = "This extension is created for a bit more Tools for Sliders. <br> Craeted by WatermelonIce <br><br> <b>My Profile in Kodular Community: </b><a href=\"https://community.kodular.io/u/WatermelonIce/summary\">My Profile</a><br><b>Support me by subscribing my YouTube Channel: </b> <a href=\"https://www.youtube.com/channel/UCBq9ouxr4C4OZG0sMCgmpwg\">WatermelonIce YouTube Channel</a>",
                   category = ComponentCategory.EXTENSION,
                   nonVisible = true,
                   iconName = "aiwebres/extension.png")

@SimpleObject(external = true)
public class SliderTools extends AndroidNonvisibleComponent {

    private Hashtable<SeekBar, Slider> sliders = new Hashtable<>();

    public SliderTools(ComponentContainer container) {
        super(container.$form());
    }

    @SimpleEvent(description = "Rasies when any error occurred.")
    public void ErrorOccurred(String error) {
        EventDispatcher.dispatchEvent(this, "ErrorOccurred", error);
    }

    @SimpleEvent(description = "Raises when any registered slider's thumb position changed. If it is changed by the user, fromUser will be true, otherwise false.")
    public void OnChange(Slider component, float progress, boolean fromUser) {
        EventDispatcher.dispatchEvent(this, "OnChange", component, progress, fromUser);
    }

    @SimpleEvent(description = "Rasies when any registered slider is touched down.")
    public void OnTouchDown(Slider component) {
        EventDispatcher.dispatchEvent(this, "OnTouchDown", component);
    }

    @SimpleEvent(description = "Rasies when any registered slider is touched down.")
    public void OnTouchUp(Slider component) {
        EventDispatcher.dispatchEvent(this, "OnTouchUp", component);
    }

    @SimpleFunction(description = "Register a slider component.")
    public void RegisterSlider(Slider slider) {

        try {
            SeekBar cSeekBar = toSeekBar(slider);
            sliders.put(cSeekBar, slider);

            cSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    float minValue = sliders.get(seekBar).MinValue();
                    float position = ((sliders.get(seekBar).MaxValue() - minValue) * (float) progress / 100) + minValue;
                    OnChange(sliders.get(seekBar), position, fromUser);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                    OnTouchDown(sliders.get(seekBar));
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    OnTouchUp(sliders.get(seekBar));
                }

            });
        } catch (Exception e) {
            ErrorOccurred(e.getMessage());
        }
    }

    @SimpleFunction(description = "Unregister a slider component.")
    public void UnregisterSlider(Slider slider) {
        try {
            toSeekBar(sliders.remove(toSeekBar(slider))).setOnSeekBarChangeListener(null);
        } catch (Exception e) {
            ErrorOccurred(e.getMessage());
        }
    }

    private SeekBar toSeekBar(Slider slider) {
        return (SeekBar) slider.getView();
    }
}