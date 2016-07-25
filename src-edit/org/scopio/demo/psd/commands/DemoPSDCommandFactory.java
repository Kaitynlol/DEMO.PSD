package org.scopio.demo.psd.commands;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.command.AddCommand;
import org.scopio.bpmn.BPMNDiagram;
import org.scopio.bpmn.BPMNFactory;
import org.scopio.bpmn.BPMNPackage;
import org.scopio.bpmn.Lane;
import org.scopio.bpmn.Pool;
import org.scopio.bpmn.SequenceFlow;
import org.scopio.bpmn.impl.PoolImpl;
import org.scopio.demo.psd.ActorBoundary;
import org.scopio.demo.psd.DemoPSDDiagram;
import org.scopio.demo.psd.ResponceLink;
import org.scopio.demo.psd.TR;
import org.scopio.diagrams.primitives.RectangleData;
import org.scopio.diagrams.util.DiagramsFacadeFactory;
import org.scopio.demo.psd.DemoPSDPackage;
import org.scopio.demo.psd.impl.TRImpl;
import org.scopio.entities.Representant;
import org.scopio.entities.util.EntitiesModelFactory;
import org.scopio.project.Project;
import org.scopio.project.commands.DiagramsCommandFactory;
import org.scopio.project.commands.ProjectCommandFactory;

public class DemoPSDCommandFactory extends ProjectCommandFactory {

	private DiagramsCommandFactory projectFactory;
	private DemoPSDDiagram projectDiagram;
	private BPMNDiagram bpmnDiagram;

	public DemoPSDCommandFactory(Project project) {
		super(project);

		projectFactory = new DiagramsCommandFactory(project);
	}

	public Command createAddDemoPSDDiagramCommand() {
		projectDiagram = (DemoPSDDiagram) DiagramsFacadeFactory.INSTANCE
				.createDiagram(DemoPSDPackage.Literals.DEMO_PSD_DIAGRAM,
						getProject().getEntitiesScope(), getProject()
								.getDiagramsScope());

		return projectFactory.createAddDiagramCommand(getProject()
				.getDiagramsScope(), projectDiagram);
	}

	public Object getProjectDiagram() {
		return projectDiagram;
	}

	public Command synchronizationWithBPMN(DemoPSDDiagram psd, BPMNDiagram bpmn) {
		projectDiagram = psd;
		bpmnDiagram = bpmn;
		projectDiagram.getChildren().clear();

		int x = 70;
		int y = 90;
		int height = 40;

		CompoundCommand cmd = new CompoundCommand();
		int transactionCount = 0;

		for (int i = 0; i < bpmn.getChildren().size(); i++) {
			if (bpmnDiagram.getChildren().get(i) instanceof PoolImpl) {

				// Getting Transaction

				cmd = FillTransaction((Pool) bpmnDiagram.getChildren().get(i),
						x, y + (height * transactionCount), -1, -1, cmd);
				transactionCount++;

			}
		}

		return cmd;
	}

	private CompoundCommand FillTransaction(Pool pool, int x, int y,
			int widght, int height, CompoundCommand cmd) {
		ActorBoundary actorEx = null;
		ActorBoundary actorIn = null;
		int laneCounter = 0;
		for (int i = 0; i < pool.getChildren().size(); i++) {
			if (pool.getChildren().get(i) instanceof Lane) {
				if (laneCounter < 1)
					actorEx = addActor((Lane) pool.getChildren().get(i), x, y
							+ (laneCounter * 150));
				else if (laneCounter == 1)
					actorIn = addActor((Lane) pool.getChildren().get(i), x, y
							+ (laneCounter * 150));
				laneCounter++;

			}
		}
		putIntoScopes(actorEx);
		cmd.append(AddCommand.create(projectFactory.getProject()
				.getEditingDomain(), projectDiagram, DemoPSDPackage.eINSTANCE
				.getActorBoundary(), actorEx));
		putIntoScopes(actorIn);
		cmd.append(AddCommand.create(projectFactory.getProject()
				.getEditingDomain(), projectDiagram, DemoPSDPackage.eINSTANCE
				.getActorBoundary(), actorIn));
		TR transaction = EntitiesModelFactory.INSTANCE.createRepresentant(
				DemoPSDPackage.Literals.TR, projectFactory.getProject()
						.getEntitiesScope(), projectDiagram.getScope());
		transaction.setBounds(new RectangleData(x, y, -1, -1));
		transaction.setName(pool.getName());
		transaction.setID(pool.getID());
		transaction.setExecutor(actorEx);
		transaction.setInitiator(actorIn);
		putIntoScopes(transaction);
		cmd.append(AddCommand.create(projectFactory.getProject()
				.getEditingDomain(), projectDiagram, DemoPSDPackage.eINSTANCE
				.getTR(), transaction));
		return cmd;
	}

	private ActorBoundary addActor(Lane lane, int x, int y) {
		ActorBoundary actor = EntitiesModelFactory.INSTANCE.createRepresentant(
				DemoPSDPackage.Literals.ACTOR_BOUNDARY, projectFactory
						.getProject().getEntitiesScope(), projectDiagram
						.getScope());
		actor.setBounds(new RectangleData(x, y, -1, -1));
		actor.setName(lane.getName());
		actor.setID(lane.getID());

		return actor;
	}

	private void putIntoScopes(Representant obj) {
		projectFactory.getProject().getContent().getEntityCollection()
				.getEntities().add(obj.getEntity());
		projectFactory.getProject().getEntitiesScope()
				.putIdentifiable(obj.getEntity());
		projectDiagram.getScope().putIdentifiable(obj);
	}

	public Command synchronizationWithBPMN(DemoPSDDiagram psd) {
		projectDiagram = psd;
		CompoundCommand cmd = new CompoundCommand();
		TR transaction = EntitiesModelFactory.INSTANCE.createRepresentant(
				DemoPSDPackage.Literals.TR, projectFactory.getProject()
						.getEntitiesScope(), projectDiagram.getScope());
		transaction.setBounds(new RectangleData(70, 90, -1, -1));
		transaction.setName("First");
		putIntoScopes(transaction);
		cmd.append(AddCommand.create(projectFactory.getProject()
				.getEditingDomain(), projectDiagram, DemoPSDPackage.eINSTANCE
				.getTR(), transaction));

		TR transaction1 = EntitiesModelFactory.INSTANCE.createRepresentant(
				DemoPSDPackage.Literals.TR, projectFactory.getProject()
						.getEntitiesScope(), projectDiagram.getScope());
		transaction1.setBounds(new RectangleData(70, 90, -1, -1));
		transaction1.setName("Second");
		putIntoScopes(transaction1);
		cmd.append(AddCommand.create(projectFactory.getProject()
				.getEditingDomain(), projectDiagram, DemoPSDPackage.eINSTANCE
				.getTR(), transaction1));

		return cmd;
	}

	public Command links(DemoPSDDiagram psd) {
		projectDiagram = psd;
		CompoundCommand cmd = new CompoundCommand();
		TR transaction = null;
		TR transaction1 = null;
		int counter = 0;
		ResponceLink link = EntitiesModelFactory.INSTANCE.createRepresentant(
				DemoPSDPackage.Literals.RESPONCE_LINK, projectFactory
						.getProject().getEntitiesScope(), projectDiagram
						.getScope());
		for (int i = 0; i < psd.getChildren().size(); i++) {
			if (projectDiagram.getChildren().get(i) instanceof TR) {
				if (counter == 0) {
					transaction = (TR) projectDiagram.getChildren().get(i);
					counter++;
				} else {
					transaction1 = (TR) projectDiagram.getChildren().get(i);
				}
			}

		}
		link.setSource(transaction);
		link.setTarget(transaction1);
		/*
		 * link.acceptsSource(transaction); link.acceptsEnds(transaction,
		 * transaction1);
		 */
		cmd.append(AddCommand.create(projectFactory.getProject()
				.getEditingDomain(), projectDiagram, DemoPSDPackage.eINSTANCE
				.getResponceLink(), link));
		return cmd;

	}

}
