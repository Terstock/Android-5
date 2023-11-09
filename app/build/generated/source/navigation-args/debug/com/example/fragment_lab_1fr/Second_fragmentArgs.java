package com.example.fragment_lab_1fr;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class Second_fragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private Second_fragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private Second_fragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static Second_fragmentArgs fromBundle(@NonNull Bundle bundle) {
    Second_fragmentArgs __result = new Second_fragmentArgs();
    bundle.setClassLoader(Second_fragmentArgs.class.getClassLoader());
    if (bundle.containsKey("namus")) {
      String namus;
      namus = bundle.getString("namus");
      if (namus == null) {
        throw new IllegalArgumentException("Argument \"namus\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("namus", namus);
    } else {
      throw new IllegalArgumentException("Required argument \"namus\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static Second_fragmentArgs fromSavedStateHandle(
      @NonNull SavedStateHandle savedStateHandle) {
    Second_fragmentArgs __result = new Second_fragmentArgs();
    if (savedStateHandle.contains("namus")) {
      String namus;
      namus = savedStateHandle.get("namus");
      if (namus == null) {
        throw new IllegalArgumentException("Argument \"namus\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("namus", namus);
    } else {
      throw new IllegalArgumentException("Required argument \"namus\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getNamus() {
    return (String) arguments.get("namus");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("namus")) {
      String namus = (String) arguments.get("namus");
      __result.putString("namus", namus);
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public SavedStateHandle toSavedStateHandle() {
    SavedStateHandle __result = new SavedStateHandle();
    if (arguments.containsKey("namus")) {
      String namus = (String) arguments.get("namus");
      __result.set("namus", namus);
    }
    return __result;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    Second_fragmentArgs that = (Second_fragmentArgs) object;
    if (arguments.containsKey("namus") != that.arguments.containsKey("namus")) {
      return false;
    }
    if (getNamus() != null ? !getNamus().equals(that.getNamus()) : that.getNamus() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getNamus() != null ? getNamus().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Second_fragmentArgs{"
        + "namus=" + getNamus()
        + "}";
  }

  public static final class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(@NonNull Second_fragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    @SuppressWarnings("unchecked")
    public Builder(@NonNull String namus) {
      if (namus == null) {
        throw new IllegalArgumentException("Argument \"namus\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("namus", namus);
    }

    @NonNull
    public Second_fragmentArgs build() {
      Second_fragmentArgs result = new Second_fragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setNamus(@NonNull String namus) {
      if (namus == null) {
        throw new IllegalArgumentException("Argument \"namus\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("namus", namus);
      return this;
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    @NonNull
    public String getNamus() {
      return (String) arguments.get("namus");
    }
  }
}
