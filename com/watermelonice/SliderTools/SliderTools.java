package com.watermelonice.SliderTools;

import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.runtime.*;
import com.google.appinventor.components.common.ComponentCategory;

import android.widget.SeekBar;

@DesignerComponent(version = 3,
                   versionName = "v1.2",
                   helpUrl = "https://github.com/WaterMelonOof/SliderTools-AI2-Kodular-Extension/",
                   description = "This extension is created for a bit more Tools for Sliders. <br> Craeted by WatermelonIce <br><br> <b>My Profile in Kodular Community: </b><a href=\"https://community.kodular.io/u/WatermelonIce/summary\">My Profile</a><br><b>Support me by subscribing my YouTube Channel: </b> <a href=\"https://www.youtube.com/channel/UCBq9ouxr4C4OZG0sMCgmpwg\">WatermelonIce YouTube Channel</a>",
                   category = ComponentCategory.EXTENSION,
                   nonVisible = true,
                   iconName = "aiwebres/extension.png")

@SimpleObject(external = true)
public class SliderTools extends AndroidNonvisibleComponent {

    public SliderTools(ComponentContainer container) {
        super(container.$form());
    }

    @SimpleEvent(description = "Rasies when any error occurred.")
    public void ErrorOccurred(String error) {
        EventDispatcher.dispatchEvent(this, "ErrorOccurred", error);
    }

    @SimpleEvent(description = "Raises when any registered slider's thumb position changed. If it is changed by the user, fromUser will be true, otherwise false.")
    public void Changed(Slider component, float progress, boolean fromUser) {
        EventDispatcher.dispatchEvent(this, "Changed", component, progress, fromUser);
    }

    @SimpleEvent(description = "Rasies when any registered slider is touched down.")
    public void TouchDown(Slider component) {
        EventDispatcher.dispatchEvent(this, "TouchDown", component);
    }

    @SimpleEvent(description = "Rasies when any registered slider is touched up.")
    public void TouchUp(Slider component) {
        EventDispatcher.dispatchEvent(this, "TouchUp", component);
    }

    @SimpleFunction(description = "Register a slider component.")
    public void RegisterSlider(final Slider slider) {

        try {

            SeekBar cSeekBar = toSeekBar(slider);
            cSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    float minValue = slider.MinValue();
                    float position = ((slider.MaxValue() - minValue) * (float) progress / 100) + minValue;
                    Changed(slider, position, fromUser);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                    TouchDown(slider);
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    TouchUp(slider);
                }

            });
        } catch (Exception e) {
            ErrorOccurred(e.getMessage());
        }
    }

    @SimpleFunction(description = "Unregister a slider component.")
    public void UnregisterSlider(Slider slider) {
        try {
            toSeekBar(slider).setOnSeekBarChangeListener(null);
        } catch (Exception e) {
            ErrorOccurred(e.getMessage());
        }
    }

    private SeekBar toSeekBar(Slider slider) {
        return (SeekBar) slider.getView();
    }
}