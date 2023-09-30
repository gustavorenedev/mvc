package br.com.gustavorene;

import br.com.gustavorene.controller.ControllerPrincipal;
import br.com.gustavorene.view.FramePrincipal;

public class MVC {
	public static void main(String[] args) {
		FramePrincipal framePincipal = new FramePrincipal();
		new ControllerPrincipal(framePincipal);
		framePincipal.setVisible(true);
	}
}
