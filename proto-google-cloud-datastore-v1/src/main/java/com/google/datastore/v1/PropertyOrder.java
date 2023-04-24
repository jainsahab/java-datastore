// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/datastore/v1/query.proto

package com.google.datastore.v1;

/**
 * <pre>
 * The desired order for a specific property.
 * </pre>
 *
 * Protobuf type {@code google.datastore.v1.PropertyOrder}
 */
public final class PropertyOrder extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:google.datastore.v1.PropertyOrder)
    PropertyOrderOrBuilder {
private static final long serialVersionUID = 0L;
  // Use PropertyOrder.newBuilder() to construct.
  private PropertyOrder(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private PropertyOrder() {
    direction_ = 0;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new PropertyOrder();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.google.datastore.v1.QueryProto.internal_static_google_datastore_v1_PropertyOrder_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.datastore.v1.QueryProto.internal_static_google_datastore_v1_PropertyOrder_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.datastore.v1.PropertyOrder.class, com.google.datastore.v1.PropertyOrder.Builder.class);
  }

  /**
   * <pre>
   * The sort direction.
   * </pre>
   *
   * Protobuf enum {@code google.datastore.v1.PropertyOrder.Direction}
   */
  public enum Direction
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <pre>
     * Unspecified. This value must not be used.
     * </pre>
     *
     * <code>DIRECTION_UNSPECIFIED = 0;</code>
     */
    DIRECTION_UNSPECIFIED(0),
    /**
     * <pre>
     * Ascending.
     * </pre>
     *
     * <code>ASCENDING = 1;</code>
     */
    ASCENDING(1),
    /**
     * <pre>
     * Descending.
     * </pre>
     *
     * <code>DESCENDING = 2;</code>
     */
    DESCENDING(2),
    UNRECOGNIZED(-1),
    ;

    /**
     * <pre>
     * Unspecified. This value must not be used.
     * </pre>
     *
     * <code>DIRECTION_UNSPECIFIED = 0;</code>
     */
    public static final int DIRECTION_UNSPECIFIED_VALUE = 0;
    /**
     * <pre>
     * Ascending.
     * </pre>
     *
     * <code>ASCENDING = 1;</code>
     */
    public static final int ASCENDING_VALUE = 1;
    /**
     * <pre>
     * Descending.
     * </pre>
     *
     * <code>DESCENDING = 2;</code>
     */
    public static final int DESCENDING_VALUE = 2;


    public final int getNumber() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalArgumentException(
            "Can't get the number of an unknown enum value.");
      }
      return value;
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static Direction valueOf(int value) {
      return forNumber(value);
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     */
    public static Direction forNumber(int value) {
      switch (value) {
        case 0: return DIRECTION_UNSPECIFIED;
        case 1: return ASCENDING;
        case 2: return DESCENDING;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<Direction>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        Direction> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<Direction>() {
            public Direction findValueByNumber(int number) {
              return Direction.forNumber(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalStateException(
            "Can't get the descriptor of an unrecognized enum value.");
      }
      return getDescriptor().getValues().get(ordinal());
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return com.google.datastore.v1.PropertyOrder.getDescriptor().getEnumTypes().get(0);
    }

    private static final Direction[] VALUES = values();

    public static Direction valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      if (desc.getIndex() == -1) {
        return UNRECOGNIZED;
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private Direction(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:google.datastore.v1.PropertyOrder.Direction)
  }

  public static final int PROPERTY_FIELD_NUMBER = 1;
  private com.google.datastore.v1.PropertyReference property_;
  /**
   * <pre>
   * The property to order by.
   * </pre>
   *
   * <code>.google.datastore.v1.PropertyReference property = 1;</code>
   * @return Whether the property field is set.
   */
  @java.lang.Override
  public boolean hasProperty() {
    return property_ != null;
  }
  /**
   * <pre>
   * The property to order by.
   * </pre>
   *
   * <code>.google.datastore.v1.PropertyReference property = 1;</code>
   * @return The property.
   */
  @java.lang.Override
  public com.google.datastore.v1.PropertyReference getProperty() {
    return property_ == null ? com.google.datastore.v1.PropertyReference.getDefaultInstance() : property_;
  }
  /**
   * <pre>
   * The property to order by.
   * </pre>
   *
   * <code>.google.datastore.v1.PropertyReference property = 1;</code>
   */
  @java.lang.Override
  public com.google.datastore.v1.PropertyReferenceOrBuilder getPropertyOrBuilder() {
    return property_ == null ? com.google.datastore.v1.PropertyReference.getDefaultInstance() : property_;
  }

  public static final int DIRECTION_FIELD_NUMBER = 2;
  private int direction_ = 0;
  /**
   * <pre>
   * The direction to order by. Defaults to `ASCENDING`.
   * </pre>
   *
   * <code>.google.datastore.v1.PropertyOrder.Direction direction = 2;</code>
   * @return The enum numeric value on the wire for direction.
   */
  @java.lang.Override public int getDirectionValue() {
    return direction_;
  }
  /**
   * <pre>
   * The direction to order by. Defaults to `ASCENDING`.
   * </pre>
   *
   * <code>.google.datastore.v1.PropertyOrder.Direction direction = 2;</code>
   * @return The direction.
   */
  @java.lang.Override public com.google.datastore.v1.PropertyOrder.Direction getDirection() {
    com.google.datastore.v1.PropertyOrder.Direction result = com.google.datastore.v1.PropertyOrder.Direction.forNumber(direction_);
    return result == null ? com.google.datastore.v1.PropertyOrder.Direction.UNRECOGNIZED : result;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (property_ != null) {
      output.writeMessage(1, getProperty());
    }
    if (direction_ != com.google.datastore.v1.PropertyOrder.Direction.DIRECTION_UNSPECIFIED.getNumber()) {
      output.writeEnum(2, direction_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (property_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getProperty());
    }
    if (direction_ != com.google.datastore.v1.PropertyOrder.Direction.DIRECTION_UNSPECIFIED.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(2, direction_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.google.datastore.v1.PropertyOrder)) {
      return super.equals(obj);
    }
    com.google.datastore.v1.PropertyOrder other = (com.google.datastore.v1.PropertyOrder) obj;

    if (hasProperty() != other.hasProperty()) return false;
    if (hasProperty()) {
      if (!getProperty()
          .equals(other.getProperty())) return false;
    }
    if (direction_ != other.direction_) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasProperty()) {
      hash = (37 * hash) + PROPERTY_FIELD_NUMBER;
      hash = (53 * hash) + getProperty().hashCode();
    }
    hash = (37 * hash) + DIRECTION_FIELD_NUMBER;
    hash = (53 * hash) + direction_;
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.google.datastore.v1.PropertyOrder parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.datastore.v1.PropertyOrder parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.datastore.v1.PropertyOrder parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.datastore.v1.PropertyOrder parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.datastore.v1.PropertyOrder parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.datastore.v1.PropertyOrder parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.datastore.v1.PropertyOrder parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.google.datastore.v1.PropertyOrder parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.google.datastore.v1.PropertyOrder parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.google.datastore.v1.PropertyOrder parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.google.datastore.v1.PropertyOrder parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.google.datastore.v1.PropertyOrder parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.google.datastore.v1.PropertyOrder prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * The desired order for a specific property.
   * </pre>
   *
   * Protobuf type {@code google.datastore.v1.PropertyOrder}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:google.datastore.v1.PropertyOrder)
      com.google.datastore.v1.PropertyOrderOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.google.datastore.v1.QueryProto.internal_static_google_datastore_v1_PropertyOrder_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.datastore.v1.QueryProto.internal_static_google_datastore_v1_PropertyOrder_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.datastore.v1.PropertyOrder.class, com.google.datastore.v1.PropertyOrder.Builder.class);
    }

    // Construct using com.google.datastore.v1.PropertyOrder.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      property_ = null;
      if (propertyBuilder_ != null) {
        propertyBuilder_.dispose();
        propertyBuilder_ = null;
      }
      direction_ = 0;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.google.datastore.v1.QueryProto.internal_static_google_datastore_v1_PropertyOrder_descriptor;
    }

    @java.lang.Override
    public com.google.datastore.v1.PropertyOrder getDefaultInstanceForType() {
      return com.google.datastore.v1.PropertyOrder.getDefaultInstance();
    }

    @java.lang.Override
    public com.google.datastore.v1.PropertyOrder build() {
      com.google.datastore.v1.PropertyOrder result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.google.datastore.v1.PropertyOrder buildPartial() {
      com.google.datastore.v1.PropertyOrder result = new com.google.datastore.v1.PropertyOrder(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.google.datastore.v1.PropertyOrder result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.property_ = propertyBuilder_ == null
            ? property_
            : propertyBuilder_.build();
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.direction_ = direction_;
      }
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.google.datastore.v1.PropertyOrder) {
        return mergeFrom((com.google.datastore.v1.PropertyOrder)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.google.datastore.v1.PropertyOrder other) {
      if (other == com.google.datastore.v1.PropertyOrder.getDefaultInstance()) return this;
      if (other.hasProperty()) {
        mergeProperty(other.getProperty());
      }
      if (other.direction_ != 0) {
        setDirectionValue(other.getDirectionValue());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              input.readMessage(
                  getPropertyFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 16: {
              direction_ = input.readEnum();
              bitField0_ |= 0x00000002;
              break;
            } // case 16
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private com.google.datastore.v1.PropertyReference property_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.datastore.v1.PropertyReference, com.google.datastore.v1.PropertyReference.Builder, com.google.datastore.v1.PropertyReferenceOrBuilder> propertyBuilder_;
    /**
     * <pre>
     * The property to order by.
     * </pre>
     *
     * <code>.google.datastore.v1.PropertyReference property = 1;</code>
     * @return Whether the property field is set.
     */
    public boolean hasProperty() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <pre>
     * The property to order by.
     * </pre>
     *
     * <code>.google.datastore.v1.PropertyReference property = 1;</code>
     * @return The property.
     */
    public com.google.datastore.v1.PropertyReference getProperty() {
      if (propertyBuilder_ == null) {
        return property_ == null ? com.google.datastore.v1.PropertyReference.getDefaultInstance() : property_;
      } else {
        return propertyBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     * The property to order by.
     * </pre>
     *
     * <code>.google.datastore.v1.PropertyReference property = 1;</code>
     */
    public Builder setProperty(com.google.datastore.v1.PropertyReference value) {
      if (propertyBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        property_ = value;
      } else {
        propertyBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * The property to order by.
     * </pre>
     *
     * <code>.google.datastore.v1.PropertyReference property = 1;</code>
     */
    public Builder setProperty(
        com.google.datastore.v1.PropertyReference.Builder builderForValue) {
      if (propertyBuilder_ == null) {
        property_ = builderForValue.build();
      } else {
        propertyBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * The property to order by.
     * </pre>
     *
     * <code>.google.datastore.v1.PropertyReference property = 1;</code>
     */
    public Builder mergeProperty(com.google.datastore.v1.PropertyReference value) {
      if (propertyBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0) &&
          property_ != null &&
          property_ != com.google.datastore.v1.PropertyReference.getDefaultInstance()) {
          getPropertyBuilder().mergeFrom(value);
        } else {
          property_ = value;
        }
      } else {
        propertyBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * The property to order by.
     * </pre>
     *
     * <code>.google.datastore.v1.PropertyReference property = 1;</code>
     */
    public Builder clearProperty() {
      bitField0_ = (bitField0_ & ~0x00000001);
      property_ = null;
      if (propertyBuilder_ != null) {
        propertyBuilder_.dispose();
        propertyBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <pre>
     * The property to order by.
     * </pre>
     *
     * <code>.google.datastore.v1.PropertyReference property = 1;</code>
     */
    public com.google.datastore.v1.PropertyReference.Builder getPropertyBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getPropertyFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     * The property to order by.
     * </pre>
     *
     * <code>.google.datastore.v1.PropertyReference property = 1;</code>
     */
    public com.google.datastore.v1.PropertyReferenceOrBuilder getPropertyOrBuilder() {
      if (propertyBuilder_ != null) {
        return propertyBuilder_.getMessageOrBuilder();
      } else {
        return property_ == null ?
            com.google.datastore.v1.PropertyReference.getDefaultInstance() : property_;
      }
    }
    /**
     * <pre>
     * The property to order by.
     * </pre>
     *
     * <code>.google.datastore.v1.PropertyReference property = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.datastore.v1.PropertyReference, com.google.datastore.v1.PropertyReference.Builder, com.google.datastore.v1.PropertyReferenceOrBuilder> 
        getPropertyFieldBuilder() {
      if (propertyBuilder_ == null) {
        propertyBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.google.datastore.v1.PropertyReference, com.google.datastore.v1.PropertyReference.Builder, com.google.datastore.v1.PropertyReferenceOrBuilder>(
                getProperty(),
                getParentForChildren(),
                isClean());
        property_ = null;
      }
      return propertyBuilder_;
    }

    private int direction_ = 0;
    /**
     * <pre>
     * The direction to order by. Defaults to `ASCENDING`.
     * </pre>
     *
     * <code>.google.datastore.v1.PropertyOrder.Direction direction = 2;</code>
     * @return The enum numeric value on the wire for direction.
     */
    @java.lang.Override public int getDirectionValue() {
      return direction_;
    }
    /**
     * <pre>
     * The direction to order by. Defaults to `ASCENDING`.
     * </pre>
     *
     * <code>.google.datastore.v1.PropertyOrder.Direction direction = 2;</code>
     * @param value The enum numeric value on the wire for direction to set.
     * @return This builder for chaining.
     */
    public Builder setDirectionValue(int value) {
      direction_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * The direction to order by. Defaults to `ASCENDING`.
     * </pre>
     *
     * <code>.google.datastore.v1.PropertyOrder.Direction direction = 2;</code>
     * @return The direction.
     */
    @java.lang.Override
    public com.google.datastore.v1.PropertyOrder.Direction getDirection() {
      com.google.datastore.v1.PropertyOrder.Direction result = com.google.datastore.v1.PropertyOrder.Direction.forNumber(direction_);
      return result == null ? com.google.datastore.v1.PropertyOrder.Direction.UNRECOGNIZED : result;
    }
    /**
     * <pre>
     * The direction to order by. Defaults to `ASCENDING`.
     * </pre>
     *
     * <code>.google.datastore.v1.PropertyOrder.Direction direction = 2;</code>
     * @param value The direction to set.
     * @return This builder for chaining.
     */
    public Builder setDirection(com.google.datastore.v1.PropertyOrder.Direction value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000002;
      direction_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * The direction to order by. Defaults to `ASCENDING`.
     * </pre>
     *
     * <code>.google.datastore.v1.PropertyOrder.Direction direction = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearDirection() {
      bitField0_ = (bitField0_ & ~0x00000002);
      direction_ = 0;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:google.datastore.v1.PropertyOrder)
  }

  // @@protoc_insertion_point(class_scope:google.datastore.v1.PropertyOrder)
  private static final com.google.datastore.v1.PropertyOrder DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.google.datastore.v1.PropertyOrder();
  }

  public static com.google.datastore.v1.PropertyOrder getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<PropertyOrder>
      PARSER = new com.google.protobuf.AbstractParser<PropertyOrder>() {
    @java.lang.Override
    public PropertyOrder parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<PropertyOrder> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PropertyOrder> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.datastore.v1.PropertyOrder getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

