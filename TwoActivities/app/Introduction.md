# The simple introduction of the practical
## Practical 1
### target
    How to create a new Activity in Android Studio.
    How to define parent and child activities for Up navigation.
    How to start an Activity with an explicit Intent.
    How to pass data between each Activity with an explicit Intent.
### task
    Create a new Android app with a main Activity and a second Activity.
    Pass some data (a string) from the main Activity to the second using an Intent, and display that data in the second Activity.
    Send a second different bit of data back to the main Activity, also using an Intent.

## Practical 2
### target
    How the Activity lifecycle works.
    When an Activity starts, pauses, stops, and is destroyed.
    About the lifecycle callback methods associated with Activity changes.
    The effect of actions (such as configuration changes) that can result in Activity lifecycle events.
    How to retain Activity state across lifecycle events.
### task
    Add code to the TwoActivities app from the previous practical to implement the various Activity lifecycle callbacks to include logging statements.
    Observe the state changes as your app runs and as you interact with each Activity in your app.
    Modify your app to retain the instance state of an Activity that is unexpectedly recreated in response to user behavior or configuration change on the device.

## Some explanation
> The state of each Activity is stored as a set of key/value pairs in a Bundle object called the Activity instance state. The system saves default state information to instance state Bundle just before the Activity is stopped, and passes that Bundle to the new Activity instance to restore.
