# TODO MVC Application Test Suite


### About

Test Stuite for UI testing of Angular Js version of TODO MVC application (http://todomvc.com/examples/angularjs/)

### Build

    mvn clean install

### Run

    mvn clean verify

OR

    mvn -Dwebdriver.driver=<iexplorer|chrome|firefox> clean verify

OR

    mvn -Dwebdriver.base.url=http://stage.todomvc.com clean verify
    
OR

    mvn -Dwebdriver.base.url=http://todomvc.com clean verify

