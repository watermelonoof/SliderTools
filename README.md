# SliderTools-AI2-Kodular-Extension
 Some useful feature for sliders in AI2 and its disturbution.
 
# Blocks
<table style="width:100%">
    <tr>
        <th style="width:40%">Blocks</th>
        <th style="width:60%">Description</th>
    </tr>
    <tr>
        <td>
            <img src="assets/BlockImages/ErrorOccurred.png" alt = "ErrorOccurred">
        </td>
        <td>Rasies when any error occurred.<br><br>
            <table>
                <tr>
                    <th>Params</th>
                    <th>Type</th>
                    <th>Description</th>
                </tr>
                <tr>
                    <td>error</td>
                    <td>String</td>
                    <td>Return an exception error in String form.</td>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td>
            <img src = "assets/BlockImages/Changed.png" alt = "OnChange">
        </td>
        <td>Raises when any registered slider's thumb position changed.<br>If it is changed by the user, fromUser will be
            true, otherwise false.<br><br>
            <table>
                <tr>
                    <th>Params</th>
                    <th>Type</th>
                    <th>Description</th>
                </tr>
                <tr>
                    <td>component</td>
                    <td>Component (Slider)</td>
                    <td>Return the component<br>that it's thumb position changed.</td>
                </tr>
                <tr>
                    <td>progress</td>
                    <td>Number (float)</td>
                    <td>Return the position of the slider<br>that it's thumn position changed.</td>
                </tr>
                <tr>
                    <td>fromUser</td>
                    <td>boolean</td>
                    <td>Return true if the change is made by the User,<br>otherwise false.</td>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td>
            <img src = "assets/BlockImages/TouchDown.png" alt = "OnTouchDown">
        </td>
        <td>Rasies when any registered slider is touched down.<br><br>
            <table>
                <tr>
                    <th>Params</th>
                    <th>Type</th>
                    <th>Description</th>
                </tr>
                <tr>
                    <td>component</td>
                    <td>Component (Slider)</td>
                    <td>Return the component that has been touched down.</td>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td>
            <img src="assets/BlockImages/TouchUp.png" alt = "OnTouchUp">
        </td>
        <td>Rasies when any registered slider is touched up.<br><br>
            <table>
                <tr>
                    <th>Params</th>
                    <th>Type</th>
                    <th>Description</th>
                </tr>
                <tr>
                    <td>component</td>
                    <td>Component (Slider)</td>
                    <td>Return the component that has been touched up.</td>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td>
            <img src="assets/BlockImages/RegisterSlider.png" alt = "Register">
        </td>
        <td>Register a slider component.<br><br>
            <table>
                <tr>
                    <th>Params</th>
                    <th>Type</th>
                    <th>Description</th>
                </tr>
                <tr>
                    <td>slider</td>
                    <td>Component (slider)</td>
                    <td>Input a slider component to register.</td>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td>
            <img src="assets/BlockImages/UnregisterSlider.png" alt = "Unregister">
        </td>
        <td>Unregister a slider component.<br><br>
            <table>
                <tr>
                    <th>Params</th>
                    <th>Type</th>
                    <th>Description</th>
                </tr>
                <tr>
                    <td>slider</td>
                    <td>Component (slider)</td>
                    <td>Input a slider component to unregister.</td>
                </tr>
            </table>
        </td>
    </tr>
</table>
	
# Errors

The Error Ocuured event will only return exception error.
	
# Change Log

## v1.2
* Bug fixed - Change event will work now
* Removed useless variable and Hashtable

## v1.1
* Changed the name of OnChange to Changed, suggested by [@Vishwas](https://community.kodular.io/u/vishwas)

# Reference
[Kodular Community](https://community.kodular.io/t/free-open-source-slidertools-bit-of-useful-feature-for-sliders/86464)
[MIT AI2 Community](https://community.appinventor.mit.edu/t/free-open-source-slidertools-bit-of-useful-feature-for-sliders/17459)
