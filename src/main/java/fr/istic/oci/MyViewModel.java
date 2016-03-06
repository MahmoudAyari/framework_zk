package fr.istic.oci;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.*;

public class MyViewModel extends SelectorComposer<Component> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ListModelList<Technologie> technos;

    public MyViewModel() {
        super();
        technos = new ListModelList<>(Ressource.technos(), true);
    }

    @Wire
    private Button addBtn;

    @Wire
    private Textbox name;

    @Wire
    private Textbox description;


    @Wire
    private Listbox technoList;

    @Wire
    private Label nameLabel;

    @Wire
    private Label descriptionLabel;

    

    @Listen("onClick = #addBtn")
    public void addTechno() {
        if (name == null || technoList == null) {
            Messagebox.show("Error on this application", "Error", Messagebox.OK, Messagebox.ERROR);
        } else {
            String text = name.getValue();
            if (text != null && !text.isEmpty()) {
                if (description != null && description.getValue() != null) {
                     
                        technos.add(new Technologie(text, description.getValue()));
                    }
                
            } else {
                Messagebox.show("The task name is empty", "Warning", Messagebox.OK, Messagebox.EXCLAMATION);
            }
        }
    }

    @Listen("onSelect = #technoList")
    public void select() {
    	int index=technoList.getSelectedIndex();
        nameLabel.setValue(((Technologie) technos.get(index)).getTechnoName());
        descriptionLabel.setValue(((Technologie) technos.get(index)).getDescription());
        
    }

    @Listen("onLoad = #technoList")
    public void consult() {
        technoList.setItemRenderer(new ListitemRenderer<Technologie>() {
            public void render(final Listitem listitem, Technologie techno, final int i) throws Exception {
                new Listcell(techno.getTechnoName()).setParent(listitem);
                Button button = new Button("Remove");
                Listcell cell3 = new Listcell();
                button.setParent(cell3);
                cell3.setParent(listitem);

                button.addEventListener("onClick", (event) -> {
                            technos.remove(i);
                            ListModel<Technologie> lm = new ListModelList<>(technos, true);
                            technoList.setModel(lm);
                        }
                );
            }
        });
    }

    @Override
    public void doAfterCompose(Component component) throws Exception {
        super.doAfterCompose(component);
        technoList.setModel(technos);
        consult();
    }
}