import scala.swing._
import java.awt.{Font,Color}

object Time {
    private val form = new java.text.SimpleDateFormat("HH:mm:ss:SSSSSSS")
     def current = form.format(java.util.Calendar.getInstance().getTime)

}

object Timer {
  def apply(interval: Int, repeats: Boolean = true)(op: => Unit) {
    val timeOut = new javax.swing.AbstractAction() {
      def actionPerformed(e : java.awt.event.ActionEvent) = op
    }
    val t = new javax.swing.Timer(interval, timeOut)
    t.setRepeats(repeats)
    t.start()


  }
}

class UI extends MainFrame {
  title = "Kusha nano Clock"
  preferredSize = new Dimension(700, 200)

  private var lastTime = Time.current
  private val clock = new Label(lastTime)
  {
    foreground = Color.BLACK
    //Chang the font type here
    font = new Font("Federal Escort Outline", Font.BOLD, 60)
  }

  contents = clock
  Timer(200)
  {
    tick()


  }
  Timer(10000, false)
  {

  }

  def tick() {

    val newTime = Time.current
    if (newTime != lastTime) {
      clock.text = newTime
      lastTime = newTime

    }
  }
}

object ClockOne {
  def main(args: Array[String]) {
    val ui = new UI
    ui.visible = true

  }
}
