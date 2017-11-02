# antizer-demo

The reagent example from https://github.com/priornix/antizer with a simple ring-based web server to demonstrate loading resources by using the `wrap-resources` middleware

## Usage

Pull the dependencies:

    $ lein deps

Compile the front-end code:

    $ lein cljsbuild once prod

Run the web server:

    $ lein run

To view the demo, open the following URL: http://0.0.0.0:3000/

## License

Copyright © 2017 Denis Fuenzalida

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
