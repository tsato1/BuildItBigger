# *BuildItBigger*

**BuildItBigger** is an android application that fetches jokes from the GCE module and passes them to the Android Library for display.

Udacity Course Project / Submitted by : **Takahide Sato**

## User Stories

The following **required** functionality is completed:

* [ ] This app contains a Java library for supplying jokes.
* [ ] This app contains an Android library with an activity that displays jokes passed to it as intent extras.
* [ ] This app contains a Google Cloud Endpoints module that supplies jokes from the Java library. Project loads jokes from GCE module via an async task.
* [ ] This app contains connected tests to verify that the async task is indeed loading jokes.
* [ ] This app contains paid/free flavors. The paid flavor has no ads, and no unnecessary dependencies.
* [ ] This app retrieves jokes from Google Cloud Endpoints module and displays them via an Activity from the Android Library.

The following **optional** features are implemented:

* [ ] The free app variant displays interstitial ads between the main activity and the joke-displaying activity.
* [ ] The app displays a loading indicator while the joke is being fetched from the server.
* [ ] The root build.gradle file contains a task that will start up the GCE dev server, run all Android tests, and shutdown the dev server.

## Diagram

Here's a simple diagram of implementation of this app

<img src='http://i.imgur.com/pvhC2eL.png' title='Diagram' width='' alt='Diagram' />

Diagram taken from [Udacity](http://www.udacity.com/).

## License

    Copyright 2016 Takahide Sato

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
