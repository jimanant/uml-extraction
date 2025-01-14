package eu.scasefp7.eclipse.umlrec.ui.papyrus.utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.uml2.uml.Element;

/**
 * This Class provides servies of adding and removing elements from the diagram or it's elements
 * @author Andr�s Dobreff, tsirelis
 */
public class ElementsManagerUtils {
	
	/**
	 * Calls the {@link DropObjectsRequest} on an EditPart. 
	 * @param EP - The EditPart that is to be added to
	 * @param diagramElement - The Element that is to be added
	 */
	public static void addElementToEditPart(EditPart EP, Element diagramElement){
		addElementsToEditPart(EP, Arrays.asList(diagramElement));
	}
	
	/**
	 * Calls the {@link DropObjectsRequest} on an EditPart. 
	 * @param EP - The EditPart that is to be added to
	 * @param diagramElements - The Elements that are to be added
	 */
	@SuppressWarnings("unchecked")
	public static void addElementsToEditPart(EditPart EP, Collection<? extends Element> diagramElements) {
		List<Element> diagramElementsList;
		
		if(!(diagramElements instanceof List<?>)){
			diagramElementsList = (List<Element>) createList(diagramElements);
		}else{
			diagramElementsList = (List<Element>) diagramElements;
		}
		
		if(!diagramElementsList.isEmpty()){
			DropObjectsRequest dropObjectsRequest = new DropObjectsRequest();
			dropObjectsRequest.setObjects(diagramElementsList);
			dropObjectsRequest.setLocation(new Point(0,0));
			Command commandDrop = EP.getCommand(dropObjectsRequest);
			if (commandDrop != null){
				commandDrop.execute();
			}
		}
	}
	
	/**
	 * Calls the {@link DropObjectsRequest} on an EditPart. 
	 * @param EP - The EditPart that is to be added to
	 * @param diagramElements - The Elements that are to be added
	 * @param coordinates - The Points where the Elements will be added
	 */
	public static void addElementsToEditPart(EditPart EP, Collection<? extends Element> diagramElements, Map<String, java.awt.Point> coordinates) {
		if(!diagramElements.isEmpty()) {
			for(Element element : diagramElements) {
				String elementID = EMFCoreUtil.getProxyID(element);
				java.awt.Point point = coordinates.get(elementID);
				int x = ((Double)point.getX()).intValue();
				int y = ((Double)point.getY()).intValue();
				
				DropObjectsRequest dropObjectsRequest = new DropObjectsRequest();
				dropObjectsRequest.setObjects(Arrays.asList(element));
				dropObjectsRequest.setLocation(new Point(x,y));
				Command commandDrop = EP.getCommand(dropObjectsRequest);
				if (commandDrop != null){
					commandDrop.execute();
				}
			}
		}
	}
	
	private static <T> List<T> createList(Collection<T> collection){
		List<T> list = new LinkedList<T>();
		for(T elem : collection){
			list.add(elem);
		}
		return list;
	}
	
	/**
	 * Calls the {@link RemoveCommand} on an EditPart. 
	 * @param editingDomain - the domain required by {@link RemoveCommand#create(EditingDomain, Object)}. It is the EditingDomain of the {@link DiagramEditPart}
	 * @param editParts - the EditParts that are to be removed
	 */
	public static void removeEditParts(EditingDomain editingDomain, List<EditPart> editParts) {
		List<Object> modelElements = new LinkedList<Object>();
		for(EditPart editPart : editParts){
			modelElements.add(editPart.getModel());
		}
		
		org.eclipse.emf.common.command.Command command = RemoveCommand.create(editingDomain, modelElements);
		if(command instanceof RemoveCommand){
			RemoveCommand removeCommand = (RemoveCommand) command;
			editingDomain.getCommandStack().execute(removeCommand);
		}
	}
}
