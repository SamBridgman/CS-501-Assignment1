Assignment 1: CS501

Samuel Bridgman
BUID: U57388469

Medium Phone API 36 on Android 16

MIN SDK: 29
This is the minimum required SDK needed to run the application. Chose this because its the latest version that 90% of devices are compatible with.

TARGET SDK: 36
This is the Android version your app is designed and tested for

COMPILE SDK: 36
This is the Android SDK used to compile the app

MainActivity
Location: app/src/main/java/com/example/assignment1/MainActivity.kt
Purpose: It’s the apps main activity, its starts the compose interface

AndroidManifest.xml
Location: app/src/main/AndroidManifest.xml
Purpose: Describes the app to Android, declares activities, themes, and permissions

App-level Gradle file:
Location: app/build.gradle.kts
Purpose: Configures the app module, such as the SDK info, app ID,  and dependencies.

Version catalog:
Location:gradle/libs.versions.toml
Purpose: Stores dependency and plugin versions in one place.

Strings.xml:
Location:app/src/main/res/values/strings.xml
Purpose:Stores text displayed by the application. Gradle can reference this

<img width="1728" height="1117" alt="Screenshot 2026-09-17 at 2 03 26 PM" src="https://github.com/user-attachments/assets/b1981df0-7425-4a91-87b6-6d6741e686b9" />
<img width="1728" height="1117" alt="Screenshot 2026-09-17 at 2 03 09 PM" src="https://github.com/user-attachments/assets/9f4b78d1-8524-4cfb-a18e-5d656a64c0e0" />


Rotation Observation:
When I rotate the device, the input loses the text, and so does any other mutableStateOf variables, such as the dimension value, output text etc.

Every state gets reverted, it goes back to the first dimension.


An android application will need to preserve this information because phones screens often rotate. If someone is typing long text into an input and they lean a certain direction, the phone may rotate, thus losing all of their progress. It is friction to the user experience.

Design choice:
Screen real estate is important in mobile apps. I have a general app header and body towards the top, once the users starts interacting with the app, I hid the header and body so preserve the real estate and not make it too overwhelming.

Screenshots:


Generative AI:
I did not use AI.
