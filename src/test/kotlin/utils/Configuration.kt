package utils

object Configuration {

    fun dataModel(): DataModel {
        return DataUtil.YAMLParse.parseProp("src/test/resources/functional-automated-tests.yaml", DataModel::class)
    }
}