# Turgo Project

![Turgo Logo](images/logo3.png)
This project is meant to create a Pragmatic Web framework. It is the result of author's dissertation. As the dissertation is still in progress, in the meantime this framework is **very much unstable** and there's no documentation. This will surely be completed as time goes by.

# The Software

## Build

This project uses [Gradle](http://www.gradle.org). All of files needed by Gradle reside in `build.gradle`, `settings.gradle`, and `gradle.properties` files.

## License

~~~
Copyright 2014, Bambang Purnomosidi D. P.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
~~~

## Documentation

Available in [documentation directory](docs/README.md)

# Author

The author ([Bambang Purnomosidi D. P.](http://bpdp.name)) is Ph.D candidate in [Electrical Engineering and Information Technology](http://pasca.te.ugm.ac.id), [Faculty of Engineering](http://www.fakultas-teknik.ugm.ac.id), [Gadjah Mada University](http://www.ugm.ac.id). He can be contacted by:
* Email: bambangpdp-with-domain-name-yahoocom-or-gmailcom
* Facebook: [/bambangpdp](http://www.facebook.com/bambangpdp)
* Twitter: [@bpdp](http://twitter.com/bpdp)

# Some notes

* [tuprolog](http://tuprolog.alice.unibo.it) is not available in Maven repository, so you have to grab them manually and then put the jar inside lib dir (see build.gradle for example). Originally, tuprolog doesn't include version in its jar, I manually change the jar file into tuprolog-version.jar.