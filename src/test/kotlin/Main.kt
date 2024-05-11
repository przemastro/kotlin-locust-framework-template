import com.github.myzhan.locust4j.Locust
import performanceTasks.ExampleTask
import performanceTasks.SomeOtherExampleTask

fun main() {
    val locust = Locust.getInstance()
    locust.setMasterHost("127.0.0.1")
    locust.setMasterPort(5557)
    locust.run(
        ExampleTask(1),
        SomeOtherExampleTask(2)
    )
}