/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.5
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package eu.scasefp7.eclipse.umlrec.internal;

public class StringList extends java.util.AbstractList<String> implements java.util.RandomAccess {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected StringList(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(StringList obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        UMLRecognizerJNI.delete_StringList(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  StringList(java.util.Collection<String> e) {
    this.reserve(e.size());
    for(String value: e) {
      this.push_back(value);
    }
  }

  public StringList() {
    this(UMLRecognizerJNI.new_StringList__SWIG_0(), true);
  }

  public StringList(long n) {
    this(UMLRecognizerJNI.new_StringList__SWIG_1(n), true);
  }

  public StringList(StringList o) {
    this(UMLRecognizerJNI.new_StringList__SWIG_2(StringList.getCPtr(o), o), true);
  }

  public long capacity() {
    return UMLRecognizerJNI.StringList_capacity(swigCPtr, this);
  }

  public void reserve(long n) {
    UMLRecognizerJNI.StringList_reserve(swigCPtr, this, n);
  }

  public boolean isEmpty() {
    return UMLRecognizerJNI.StringList_isEmpty(swigCPtr, this);
  }

  public void clear() {
    UMLRecognizerJNI.StringList_clear(swigCPtr, this);
  }

  public void push_back(String x) {
    UMLRecognizerJNI.StringList_push_back(swigCPtr, this, x);
  }

  public String get(int i) {
    return UMLRecognizerJNI.StringList_get(swigCPtr, this, i);
  }

  public String set(int i, String VECTOR_VALUE_IN) {
    return UMLRecognizerJNI.StringList_set(swigCPtr, this, i, VECTOR_VALUE_IN);
  }

  public int size() {
    return UMLRecognizerJNI.StringList_size(swigCPtr, this);
  }

  public void removeRange(int from, int to) {
    UMLRecognizerJNI.StringList_removeRange(swigCPtr, this, from, to);
  }

}
