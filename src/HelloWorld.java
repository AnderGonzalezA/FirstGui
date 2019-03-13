import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.MessageBox;

public class HelloWorld {

	protected Shell shell;
	private Text usernameTextbox;
	private Text passwordTextbox;

	private String userName = null;
	private String password = null;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			HelloWorld window = new HelloWorld();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");

		Label usernameLabel = new Label(shell, SWT.NONE);
		usernameLabel.setBounds(101, 38, 55, 15);
		usernameLabel.setText("Username");

		Label passwordLabel = new Label(shell, SWT.NONE);
		passwordLabel.setBounds(101, 112, 55, 15);
		passwordLabel.setText("Password");

		usernameTextbox = new Text(shell, SWT.BORDER);
		usernameTextbox.setBounds(204, 35, 76, 21);

		passwordTextbox = new Text(shell, SWT.BORDER);
		passwordTextbox.setBounds(204, 109, 76, 21);
		passwordTextbox.setEchoChar('*');

		Button loginButton = new Button(shell, SWT.NONE);
		loginButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("Login selected");

				userName = usernameTextbox.getText();
				password = passwordTextbox.getText();

				if (userName == null || userName.isEmpty() || password == null || password.isEmpty()) {
					String errorMsg = null;
					MessageBox messageBox = new MessageBox(shell, SWT.OK | SWT.ICON_ERROR);

					messageBox.setText("Alert");
					if (userName == null || userName.isEmpty()) {
						errorMsg = "Please enter username";
					} else if (password == null || password.isEmpty()) {
						errorMsg = "Please enter password";
					}
					if (errorMsg != null) {
						messageBox.setMessage(errorMsg);
						messageBox.open();
					}
				} else {
					MessageBox messageBox = new MessageBox(shell, SWT.OK | SWT.ICON_WORKING);
					messageBox.setText("Info");
					messageBox.setMessage("Valid");
					messageBox.open();
				}
			}
		});
		loginButton.setBounds(204, 176, 76, 25);
		loginButton.setText("Login");

	}
}
