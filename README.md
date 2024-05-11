# locust-kotlin-template
![Java version](https://img.shields.io/badge/Java-1.11-%23b07219)
![Python version](https://img.shields.io/badge/Python-3.9.9-%23b07219)
![Locust version](https://img.shields.io/badge/Locust-2.6.0-%23b07219)


# Features
A template of a locust implementation in Kotlin Maven framework 

1. Performance tasks for Locust manual tests

# Installation

1. Open repo in your favourite IDE (I use Intellij because of built-in Maven) and set Project SDK to "java version 1.11.0_*"
2. Right click on pom.xml and set MAVEN project, you might need to re-import maven dependencies
3. Install Python 3.7+ (if not installed yet). Be sure this version is set to default by providing in terminal "python -V"
4. Install locust: "brew install locust"

# Run

1. Run locust service: "locust -f locust-master.py --master --master-bind-host=127.0.0.1 --master-bind-port=5557"
2. Run Main.kt class which contains list of tasks to be executed in locust service

# Usage

1. In browser navigate to: http://localhost:8089/
2. If locust works fine define number od users and Start Swarming
