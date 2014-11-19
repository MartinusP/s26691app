package s26691app.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

public class S26691app implements EntryPoint {
	
	private ListBox lb1 = null;
	
	public void refreshLb1(){
		final S26691appServiceAsync s26691appService= GWT.create(S26691appService.class);
		s26691appService.getS26691app(new AsyncCallback<String[]>(){
			public void onFailure(Throwable error){
				RootPanel.get().add(new Label("ERROR " + error));
			}
			
			public void onSuccess(String[] s26691app){
				RootPanel.get().add(new Label("SUCCESS"));
				for(String s:s26691app){
					RootPanel.get().add(new Label(s));
					lb1.addItem(s);
				}
				
			}

		});
	}


	public void onModuleLoad() {
		
		lb1 = new ListBox();
		lb1.setVisibleItemCount(5);
		refreshLb1();
		RootPanel.get("listbox1").add(lb1);
		
		TextBox tb1= new TextBox();
		RootPanel.get("textbox1").add(tb1);
		
		Button b1= new Button("Send");
		RootPanel.get("button1").add(b1);
		
		
	}
}
