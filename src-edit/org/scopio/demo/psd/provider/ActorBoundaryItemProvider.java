/**
 */
package org.scopio.demo.psd.provider;


import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.scopio.demo.psd.ActorBoundary;
import org.scopio.demo.psd.DemoPSDPackage;

import org.scopio.diagrams.provider.ComponentItemProvider;

import org.scopio.entities.EntitiesPackage;

/**
 * This is the item provider adapter for a {@link org.scopio.demo.psd.ActorBoundary} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ActorBoundaryItemProvider extends ComponentItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActorBoundaryItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addIDPropertyDescriptor(object);
			addParentScopePropertyDescriptor(object);
			addDescriptionPropertyDescriptor(object);
			addDescriptionAsLabelPropertyDescriptor(object);
			addLabelPropertyDescriptor(object);
			addEntityPropertyDescriptor(object);
			addNamePropertyDescriptor(object);
			addReference1PropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the ID feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIDPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Identifiable_ID_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Identifiable_ID_feature", "_UI_Identifiable_type"),
				 EntitiesPackage.Literals.IDENTIFIABLE__ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Parent Scope feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addParentScopePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Identifiable_parentScope_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Identifiable_parentScope_feature", "_UI_Identifiable_type"),
				 EntitiesPackage.Literals.IDENTIFIABLE__PARENT_SCOPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Description feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDescriptionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Representant_description_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Representant_description_feature", "_UI_Representant_type"),
				 EntitiesPackage.Literals.REPRESENTANT__DESCRIPTION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Description As Label feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDescriptionAsLabelPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Representant_descriptionAsLabel_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Representant_descriptionAsLabel_feature", "_UI_Representant_type"),
				 EntitiesPackage.Literals.REPRESENTANT__DESCRIPTION_AS_LABEL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Label feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLabelPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Representant_label_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Representant_label_feature", "_UI_Representant_type"),
				 EntitiesPackage.Literals.REPRESENTANT__LABEL,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Entity feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEntityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Representant_entity_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Representant_entity_feature", "_UI_Representant_type"),
				 EntitiesPackage.Literals.REPRESENTANT__ENTITY,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ActorBoundary_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ActorBoundary_name_feature", "_UI_ActorBoundary_type"),
				 DemoPSDPackage.Literals.ACTOR_BOUNDARY__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Reference1 feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReference1PropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ActorBoundary_Reference1_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ActorBoundary_Reference1_feature", "_UI_ActorBoundary_type"),
				 DemoPSDPackage.Literals.ACTOR_BOUNDARY__REFERENCE1,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean shouldComposeCreationImage() {
		return true;
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ActorBoundary)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_ActorBoundary_type") :
			getString("_UI_ActorBoundary_type") + " " + label;
	}
	

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(ActorBoundary.class)) {
			case DemoPSDPackage.ACTOR_BOUNDARY__ID:
			case DemoPSDPackage.ACTOR_BOUNDARY__PARENT_SCOPE:
			case DemoPSDPackage.ACTOR_BOUNDARY__DESCRIPTION:
			case DemoPSDPackage.ACTOR_BOUNDARY__DESCRIPTION_AS_LABEL:
			case DemoPSDPackage.ACTOR_BOUNDARY__LABEL:
			case DemoPSDPackage.ACTOR_BOUNDARY__NAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return DemoPSDEditPlugin.INSTANCE;
	}

}
