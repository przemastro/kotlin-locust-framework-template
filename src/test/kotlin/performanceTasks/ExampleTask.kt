package performanceTasks
import com.github.myzhan.locust4j.AbstractTask
import com.github.myzhan.locust4j.Locust
import utils.ApiRest
import utils.Configuration.dataModel

class ExampleTask (private val weight: Int) : AbstractTask(){

    private val apiRest = ApiRest()

    override fun getWeight(): Int {
        return weight
    }

    override fun getName(): String {
        return "Example Task"
    }

    override fun execute() {
            apiRest.request("GET", dataModel().exampleTaskEndpoint)
            apiRest.getLastResponse()?.getTime()?.let { Locust.getInstance().recordSuccess("http", name, it, 1) }
    }
}