import SwiftUI
import shared

struct ContentView: View {
	let greet = Greeting().greeting()
	let compose = ComposeViewTest().dolphinCompose()

	var body: some View {
		Text(greet + " " + compose)
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}