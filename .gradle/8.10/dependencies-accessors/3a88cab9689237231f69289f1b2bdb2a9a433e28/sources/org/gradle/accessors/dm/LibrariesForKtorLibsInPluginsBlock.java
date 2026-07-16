package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the {@code ktorLibs} extension.
 */
@NonNullApi
public class LibrariesForKtorLibsInPluginsBlock extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final ClientLibraryAccessors laccForClientLibraryAccessors = new ClientLibraryAccessors(owner);
    private final HtmxLibraryAccessors laccForHtmxLibraryAccessors = new HtmxLibraryAccessors(owner);
    private final HttpLibraryAccessors laccForHttpLibraryAccessors = new HttpLibraryAccessors(owner);
    private final NetworkLibraryAccessors laccForNetworkLibraryAccessors = new NetworkLibraryAccessors(owner);
    private final OpenapiSchemaLibraryAccessors laccForOpenapiSchemaLibraryAccessors = new OpenapiSchemaLibraryAccessors(owner);
    private final SerializationLibraryAccessors laccForSerializationLibraryAccessors = new SerializationLibraryAccessors(owner);
    private final ServerLibraryAccessors laccForServerLibraryAccessors = new ServerLibraryAccessors(owner);
    private final WebsocketsLibraryAccessors laccForWebsocketsLibraryAccessors = new WebsocketsLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForKtorLibsInPluginsBlock(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

    /**
     * Dependency provider for <b>bom</b> with <b>io.ktor:ktor-bom</b> coordinates and
     * with version reference <b>ktor</b>
     * <p>
     * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
     *
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public Provider<MinimalExternalModuleDependency> getBom() {
        org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
        return create("bom");
    }

    /**
     * Dependency provider for <b>callId</b> with <b>io.ktor:ktor-call-id</b> coordinates and
     * with version reference <b>ktor</b>
     * <p>
     * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
     *
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public Provider<MinimalExternalModuleDependency> getCallId() {
        org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
        return create("callId");
    }

    /**
     * Dependency provider for <b>compilerPlugin</b> with <b>io.ktor:ktor-compiler-plugin</b> coordinates and
     * with version reference <b>ktor</b>
     * <p>
     * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
     *
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public Provider<MinimalExternalModuleDependency> getCompilerPlugin() {
        org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
        return create("compilerPlugin");
    }

    /**
     * Dependency provider for <b>encodingZstd</b> with <b>io.ktor:ktor-encoding-zstd</b> coordinates and
     * with version reference <b>ktor</b>
     * <p>
     * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
     *
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public Provider<MinimalExternalModuleDependency> getEncodingZstd() {
        org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
        return create("encodingZstd");
    }

    /**
     * Dependency provider for <b>events</b> with <b>io.ktor:ktor-events</b> coordinates and
     * with version reference <b>ktor</b>
     * <p>
     * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
     *
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public Provider<MinimalExternalModuleDependency> getEvents() {
        org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
        return create("events");
    }

    /**
     * Dependency provider for <b>gradlePlugin</b> with <b>io.ktor.plugin:plugin</b> coordinates and
     * with version reference <b>ktor</b>
     * <p>
     * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
     *
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public Provider<MinimalExternalModuleDependency> getGradlePlugin() {
        org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
        return create("gradlePlugin");
    }

    /**
     * Dependency provider for <b>io</b> with <b>io.ktor:ktor-io</b> coordinates and
     * with version reference <b>ktor</b>
     * <p>
     * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
     *
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public Provider<MinimalExternalModuleDependency> getIo() {
        org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
        return create("io");
    }

    /**
     * Dependency provider for <b>resources</b> with <b>io.ktor:ktor-resources</b> coordinates and
     * with version reference <b>ktor</b>
     * <p>
     * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
     *
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public Provider<MinimalExternalModuleDependency> getResources() {
        org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
        return create("resources");
    }

    /**
     * Dependency provider for <b>sse</b> with <b>io.ktor:ktor-sse</b> coordinates and
     * with version reference <b>ktor</b>
     * <p>
     * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
     *
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public Provider<MinimalExternalModuleDependency> getSse() {
        org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
        return create("sse");
    }

    /**
     * Dependency provider for <b>testDispatcher</b> with <b>io.ktor:ktor-test-dispatcher</b> coordinates and
     * with version reference <b>ktor</b>
     * <p>
     * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
     *
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public Provider<MinimalExternalModuleDependency> getTestDispatcher() {
        org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
        return create("testDispatcher");
    }

    /**
     * Dependency provider for <b>utils</b> with <b>io.ktor:ktor-utils</b> coordinates and
     * with version reference <b>ktor</b>
     * <p>
     * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
     *
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public Provider<MinimalExternalModuleDependency> getUtils() {
        org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
        return create("utils");
    }

    /**
     * Group of libraries at <b>client</b>
     *
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public ClientLibraryAccessors getClient() {
        org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
        return laccForClientLibraryAccessors;
    }

    /**
     * Group of libraries at <b>htmx</b>
     *
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public HtmxLibraryAccessors getHtmx() {
        org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
        return laccForHtmxLibraryAccessors;
    }

    /**
     * Group of libraries at <b>http</b>
     *
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public HttpLibraryAccessors getHttp() {
        org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
        return laccForHttpLibraryAccessors;
    }

    /**
     * Group of libraries at <b>network</b>
     *
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public NetworkLibraryAccessors getNetwork() {
        org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
        return laccForNetworkLibraryAccessors;
    }

    /**
     * Group of libraries at <b>openapiSchema</b>
     *
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public OpenapiSchemaLibraryAccessors getOpenapiSchema() {
        org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
        return laccForOpenapiSchemaLibraryAccessors;
    }

    /**
     * Group of libraries at <b>serialization</b>
     *
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public SerializationLibraryAccessors getSerialization() {
        org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
        return laccForSerializationLibraryAccessors;
    }

    /**
     * Group of libraries at <b>server</b>
     *
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public ServerLibraryAccessors getServer() {
        org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
        return laccForServerLibraryAccessors;
    }

    /**
     * Group of libraries at <b>websockets</b>
     *
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public WebsocketsLibraryAccessors getWebsockets() {
        org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
        return laccForWebsocketsLibraryAccessors;
    }

    /**
     * Group of versions at <b>versions</b>
     */
    public VersionAccessors getVersions() {
        return vaccForVersionAccessors;
    }

    /**
     * Group of bundles at <b>bundles</b>
     *
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public BundleAccessors getBundles() {
        org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
        return baccForBundleAccessors;
    }

    /**
     * Group of plugins at <b>plugins</b>
     */
    public PluginAccessors getPlugins() {
        return paccForPluginAccessors;
    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ClientLibraryAccessors extends SubDependencyFactory {
        private final ClientDarwinLibraryAccessors laccForClientDarwinLibraryAccessors = new ClientDarwinLibraryAccessors(owner);
        private final ClientJettyLibraryAccessors laccForClientJettyLibraryAccessors = new ClientJettyLibraryAccessors(owner);

        public ClientLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>android</b> with <b>io.ktor:ktor-client-android</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getAndroid() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("client.android");
        }

        /**
         * Dependency provider for <b>apache</b> with <b>io.ktor:ktor-client-apache</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getApache() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("client.apache");
        }

        /**
         * Dependency provider for <b>apache5</b> with <b>io.ktor:ktor-client-apache5</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getApache5() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("client.apache5");
        }

        /**
         * Dependency provider for <b>auth</b> with <b>io.ktor:ktor-client-auth</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getAuth() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("client.auth");
        }

        /**
         * Dependency provider for <b>bomRemover</b> with <b>io.ktor:ktor-client-bom-remover</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getBomRemover() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("client.bomRemover");
        }

        /**
         * Dependency provider for <b>callId</b> with <b>io.ktor:ktor-client-call-id</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getCallId() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("client.callId");
        }

        /**
         * Dependency provider for <b>cio</b> with <b>io.ktor:ktor-client-cio</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getCio() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("client.cio");
        }

        /**
         * Dependency provider for <b>contentNegotiation</b> with <b>io.ktor:ktor-client-content-negotiation</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getContentNegotiation() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("client.contentNegotiation");
        }

        /**
         * Dependency provider for <b>core</b> with <b>io.ktor:ktor-client-core</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getCore() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("client.core");
        }

        /**
         * Dependency provider for <b>curl</b> with <b>io.ktor:ktor-client-curl</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getCurl() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("client.curl");
        }

        /**
         * Dependency provider for <b>encoding</b> with <b>io.ktor:ktor-client-encoding</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getEncoding() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("client.encoding");
        }

        /**
         * Dependency provider for <b>gson</b> with <b>io.ktor:ktor-client-gson</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getGson() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("client.gson");
        }

        /**
         * Dependency provider for <b>ios</b> with <b>io.ktor:ktor-client-ios</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getIos() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("client.ios");
        }

        /**
         * Dependency provider for <b>jackson</b> with <b>io.ktor:ktor-client-jackson</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getJackson() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("client.jackson");
        }

        /**
         * Dependency provider for <b>java</b> with <b>io.ktor:ktor-client-java</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getJava() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("client.java");
        }

        /**
         * Dependency provider for <b>js</b> with <b>io.ktor:ktor-client-js</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getJs() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("client.js");
        }

        /**
         * Dependency provider for <b>json</b> with <b>io.ktor:ktor-client-json</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getJson() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("client.json");
        }

        /**
         * Dependency provider for <b>logging</b> with <b>io.ktor:ktor-client-logging</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getLogging() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("client.logging");
        }

        /**
         * Dependency provider for <b>mock</b> with <b>io.ktor:ktor-client-mock</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getMock() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("client.mock");
        }

        /**
         * Dependency provider for <b>okhttp</b> with <b>io.ktor:ktor-client-okhttp</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getOkhttp() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("client.okhttp");
        }

        /**
         * Dependency provider for <b>resources</b> with <b>io.ktor:ktor-client-resources</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getResources() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("client.resources");
        }

        /**
         * Dependency provider for <b>serialization</b> with <b>io.ktor:ktor-client-serialization</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getSerialization() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("client.serialization");
        }

        /**
         * Dependency provider for <b>webrtc</b> with <b>io.ktor:ktor-client-webrtc</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getWebrtc() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("client.webrtc");
        }

        /**
         * Dependency provider for <b>websockets</b> with <b>io.ktor:ktor-client-websockets</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getWebsockets() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("client.websockets");
        }

        /**
         * Dependency provider for <b>winhttp</b> with <b>io.ktor:ktor-client-winhttp</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getWinhttp() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("client.winhttp");
        }

        /**
         * Group of libraries at <b>client.darwin</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public ClientDarwinLibraryAccessors getDarwin() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForClientDarwinLibraryAccessors;
        }

        /**
         * Group of libraries at <b>client.jetty</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public ClientJettyLibraryAccessors getJetty() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForClientJettyLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ClientDarwinLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public ClientDarwinLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>darwin</b> with <b>io.ktor:ktor-client-darwin</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> asProvider() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("client.darwin");
        }

        /**
         * Dependency provider for <b>legacy</b> with <b>io.ktor:ktor-client-darwin-legacy</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getLegacy() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("client.darwin.legacy");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ClientJettyLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public ClientJettyLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>jetty</b> with <b>io.ktor:ktor-client-jetty-jakarta</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> asProvider() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("client.jetty");
        }

        /**
         * Dependency provider for <b>legacy</b> with <b>io.ktor:ktor-client-jetty</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getLegacy() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("client.jetty.legacy");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class HtmxLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public HtmxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>htmx</b> with <b>io.ktor:ktor-htmx</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> asProvider() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("htmx");
        }

        /**
         * Dependency provider for <b>html</b> with <b>io.ktor:ktor-htmx-html</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getHtml() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("htmx.html");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class HttpLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public HttpLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>http</b> with <b>io.ktor:ktor-http</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> asProvider() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("http");
        }

        /**
         * Dependency provider for <b>cio</b> with <b>io.ktor:ktor-http-cio</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getCio() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("http.cio");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class NetworkLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {
        private final NetworkTlsLibraryAccessors laccForNetworkTlsLibraryAccessors = new NetworkTlsLibraryAccessors(owner);

        public NetworkLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>network</b> with <b>io.ktor:ktor-network</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> asProvider() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("network");
        }

        /**
         * Group of libraries at <b>network.tls</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public NetworkTlsLibraryAccessors getTls() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForNetworkTlsLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class NetworkTlsLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public NetworkTlsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>tls</b> with <b>io.ktor:ktor-network-tls</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> asProvider() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("network.tls");
        }

        /**
         * Dependency provider for <b>certificates</b> with <b>io.ktor:ktor-network-tls-certificates</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getCertificates() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("network.tls.certificates");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OpenapiSchemaLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public OpenapiSchemaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>openapiSchema</b> with <b>io.ktor:ktor-openapi-schema</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> asProvider() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("openapiSchema");
        }

        /**
         * Dependency provider for <b>reflect</b> with <b>io.ktor:ktor-openapi-schema-reflect</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getReflect() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("openapiSchema.reflect");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class SerializationLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {
        private final SerializationKotlinxLibraryAccessors laccForSerializationKotlinxLibraryAccessors = new SerializationKotlinxLibraryAccessors(owner);

        public SerializationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>serialization</b> with <b>io.ktor:ktor-serialization</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> asProvider() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("serialization");
        }

        /**
         * Dependency provider for <b>gson</b> with <b>io.ktor:ktor-serialization-gson</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getGson() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("serialization.gson");
        }

        /**
         * Dependency provider for <b>jackson</b> with <b>io.ktor:ktor-serialization-jackson</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getJackson() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("serialization.jackson");
        }

        /**
         * Dependency provider for <b>jackson3</b> with <b>io.ktor:ktor-serialization-jackson3</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getJackson3() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("serialization.jackson3");
        }

        /**
         * Group of libraries at <b>serialization.kotlinx</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public SerializationKotlinxLibraryAccessors getKotlinx() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForSerializationKotlinxLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class SerializationKotlinxLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public SerializationKotlinxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>kotlinx</b> with <b>io.ktor:ktor-serialization-kotlinx</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> asProvider() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("serialization.kotlinx");
        }

        /**
         * Dependency provider for <b>cbor</b> with <b>io.ktor:ktor-serialization-kotlinx-cbor</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getCbor() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("serialization.kotlinx.cbor");
        }

        /**
         * Dependency provider for <b>json</b> with <b>io.ktor:ktor-serialization-kotlinx-json</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getJson() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("serialization.kotlinx.json");
        }

        /**
         * Dependency provider for <b>protobuf</b> with <b>io.ktor:ktor-serialization-kotlinx-protobuf</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getProtobuf() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("serialization.kotlinx.protobuf");
        }

        /**
         * Dependency provider for <b>xml</b> with <b>io.ktor:ktor-serialization-kotlinx-xml</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getXml() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("serialization.kotlinx.xml");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ServerLibraryAccessors extends SubDependencyFactory {
        private final ServerAuthLibraryAccessors laccForServerAuthLibraryAccessors = new ServerAuthLibraryAccessors(owner);
        private final ServerCompressionLibraryAccessors laccForServerCompressionLibraryAccessors = new ServerCompressionLibraryAccessors(owner);
        private final ServerConfigLibraryAccessors laccForServerConfigLibraryAccessors = new ServerConfigLibraryAccessors(owner);
        private final ServerJettyLibraryAccessors laccForServerJettyLibraryAccessors = new ServerJettyLibraryAccessors(owner);
        private final ServerMetricsLibraryAccessors laccForServerMetricsLibraryAccessors = new ServerMetricsLibraryAccessors(owner);
        private final ServerServletLibraryAccessors laccForServerServletLibraryAccessors = new ServerServletLibraryAccessors(owner);
        private final ServerTomcatLibraryAccessors laccForServerTomcatLibraryAccessors = new ServerTomcatLibraryAccessors(owner);

        public ServerLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>autoHeadResponse</b> with <b>io.ktor:ktor-server-auto-head-response</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getAutoHeadResponse() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.autoHeadResponse");
        }

        /**
         * Dependency provider for <b>bodyLimit</b> with <b>io.ktor:ktor-server-body-limit</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getBodyLimit() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.bodyLimit");
        }

        /**
         * Dependency provider for <b>cachingHeaders</b> with <b>io.ktor:ktor-server-caching-headers</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getCachingHeaders() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.cachingHeaders");
        }

        /**
         * Dependency provider for <b>callId</b> with <b>io.ktor:ktor-server-call-id</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getCallId() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.callId");
        }

        /**
         * Dependency provider for <b>callLogging</b> with <b>io.ktor:ktor-server-call-logging</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getCallLogging() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.callLogging");
        }

        /**
         * Dependency provider for <b>cio</b> with <b>io.ktor:ktor-server-cio</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getCio() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.cio");
        }

        /**
         * Dependency provider for <b>conditionalHeaders</b> with <b>io.ktor:ktor-server-conditional-headers</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getConditionalHeaders() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.conditionalHeaders");
        }

        /**
         * Dependency provider for <b>contentNegotiation</b> with <b>io.ktor:ktor-server-content-negotiation</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getContentNegotiation() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.contentNegotiation");
        }

        /**
         * Dependency provider for <b>core</b> with <b>io.ktor:ktor-server-core</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getCore() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.core");
        }

        /**
         * Dependency provider for <b>cors</b> with <b>io.ktor:ktor-server-cors</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getCors() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.cors");
        }

        /**
         * Dependency provider for <b>csrf</b> with <b>io.ktor:ktor-server-csrf</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getCsrf() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.csrf");
        }

        /**
         * Dependency provider for <b>dataConversion</b> with <b>io.ktor:ktor-server-data-conversion</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getDataConversion() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.dataConversion");
        }

        /**
         * Dependency provider for <b>defaultHeaders</b> with <b>io.ktor:ktor-server-default-headers</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getDefaultHeaders() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.defaultHeaders");
        }

        /**
         * Dependency provider for <b>di</b> with <b>io.ktor:ktor-server-di</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getDi() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.di");
        }

        /**
         * Dependency provider for <b>doubleReceive</b> with <b>io.ktor:ktor-server-double-receive</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getDoubleReceive() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.doubleReceive");
        }

        /**
         * Dependency provider for <b>forwardedHeader</b> with <b>io.ktor:ktor-server-forwarded-header</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getForwardedHeader() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.forwardedHeader");
        }

        /**
         * Dependency provider for <b>freemarker</b> with <b>io.ktor:ktor-server-freemarker</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getFreemarker() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.freemarker");
        }

        /**
         * Dependency provider for <b>hsts</b> with <b>io.ktor:ktor-server-hsts</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getHsts() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.hsts");
        }

        /**
         * Dependency provider for <b>htmlBuilder</b> with <b>io.ktor:ktor-server-html-builder</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getHtmlBuilder() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.htmlBuilder");
        }

        /**
         * Dependency provider for <b>htmx</b> with <b>io.ktor:ktor-server-htmx</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getHtmx() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.htmx");
        }

        /**
         * Dependency provider for <b>httpRedirect</b> with <b>io.ktor:ktor-server-http-redirect</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getHttpRedirect() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.httpRedirect");
        }

        /**
         * Dependency provider for <b>i18n</b> with <b>io.ktor:ktor-server-i18n</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getI18n() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.i18n");
        }

        /**
         * Dependency provider for <b>jte</b> with <b>io.ktor:ktor-server-jte</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getJte() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.jte");
        }

        /**
         * Dependency provider for <b>methodOverride</b> with <b>io.ktor:ktor-server-method-override</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getMethodOverride() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.methodOverride");
        }

        /**
         * Dependency provider for <b>mustache</b> with <b>io.ktor:ktor-server-mustache</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getMustache() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.mustache");
        }

        /**
         * Dependency provider for <b>netty</b> with <b>io.ktor:ktor-server-netty</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getNetty() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.netty");
        }

        /**
         * Dependency provider for <b>openapi</b> with <b>io.ktor:ktor-server-openapi</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getOpenapi() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.openapi");
        }

        /**
         * Dependency provider for <b>partialContent</b> with <b>io.ktor:ktor-server-partial-content</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getPartialContent() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.partialContent");
        }

        /**
         * Dependency provider for <b>pebble</b> with <b>io.ktor:ktor-server-pebble</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getPebble() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.pebble");
        }

        /**
         * Dependency provider for <b>rateLimit</b> with <b>io.ktor:ktor-server-rate-limit</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getRateLimit() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.rateLimit");
        }

        /**
         * Dependency provider for <b>requestValidation</b> with <b>io.ktor:ktor-server-request-validation</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getRequestValidation() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.requestValidation");
        }

        /**
         * Dependency provider for <b>resources</b> with <b>io.ktor:ktor-server-resources</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getResources() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.resources");
        }

        /**
         * Dependency provider for <b>routingOpenapi</b> with <b>io.ktor:ktor-server-routing-openapi</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getRoutingOpenapi() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.routingOpenapi");
        }

        /**
         * Dependency provider for <b>sessions</b> with <b>io.ktor:ktor-server-sessions</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getSessions() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.sessions");
        }

        /**
         * Dependency provider for <b>sse</b> with <b>io.ktor:ktor-server-sse</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getSse() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.sse");
        }

        /**
         * Dependency provider for <b>statusPages</b> with <b>io.ktor:ktor-server-status-pages</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getStatusPages() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.statusPages");
        }

        /**
         * Dependency provider for <b>swagger</b> with <b>io.ktor:ktor-server-swagger</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getSwagger() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.swagger");
        }

        /**
         * Dependency provider for <b>testHost</b> with <b>io.ktor:ktor-server-test-host</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getTestHost() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.testHost");
        }

        /**
         * Dependency provider for <b>thymeleaf</b> with <b>io.ktor:ktor-server-thymeleaf</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getThymeleaf() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.thymeleaf");
        }

        /**
         * Dependency provider for <b>velocity</b> with <b>io.ktor:ktor-server-velocity</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getVelocity() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.velocity");
        }

        /**
         * Dependency provider for <b>webjars</b> with <b>io.ktor:ktor-server-webjars</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getWebjars() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.webjars");
        }

        /**
         * Dependency provider for <b>websockets</b> with <b>io.ktor:ktor-server-websockets</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getWebsockets() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.websockets");
        }

        /**
         * Group of libraries at <b>server.auth</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public ServerAuthLibraryAccessors getAuth() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForServerAuthLibraryAccessors;
        }

        /**
         * Group of libraries at <b>server.compression</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public ServerCompressionLibraryAccessors getCompression() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForServerCompressionLibraryAccessors;
        }

        /**
         * Group of libraries at <b>server.config</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public ServerConfigLibraryAccessors getConfig() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForServerConfigLibraryAccessors;
        }

        /**
         * Group of libraries at <b>server.jetty</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public ServerJettyLibraryAccessors getJetty() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForServerJettyLibraryAccessors;
        }

        /**
         * Group of libraries at <b>server.metrics</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public ServerMetricsLibraryAccessors getMetrics() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForServerMetricsLibraryAccessors;
        }

        /**
         * Group of libraries at <b>server.servlet</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public ServerServletLibraryAccessors getServlet() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForServerServletLibraryAccessors;
        }

        /**
         * Group of libraries at <b>server.tomcat</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public ServerTomcatLibraryAccessors getTomcat() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForServerTomcatLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ServerAuthLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public ServerAuthLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>auth</b> with <b>io.ktor:ktor-server-auth</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> asProvider() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.auth");
        }

        /**
         * Dependency provider for <b>apiKey</b> with <b>io.ktor:ktor-server-auth-api-key</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getApiKey() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.auth.apiKey");
        }

        /**
         * Dependency provider for <b>jwt</b> with <b>io.ktor:ktor-server-auth-jwt</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getJwt() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.auth.jwt");
        }

        /**
         * Dependency provider for <b>ldap</b> with <b>io.ktor:ktor-server-auth-ldap</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getLdap() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.auth.ldap");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ServerCompressionLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public ServerCompressionLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>compression</b> with <b>io.ktor:ktor-server-compression</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> asProvider() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.compression");
        }

        /**
         * Dependency provider for <b>zstd</b> with <b>io.ktor:ktor-server-compression-zstd</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getZstd() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.compression.zstd");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ServerConfigLibraryAccessors extends SubDependencyFactory {

        public ServerConfigLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>yaml</b> with <b>io.ktor:ktor-server-config-yaml</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getYaml() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.config.yaml");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ServerJettyLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public ServerJettyLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>jetty</b> with <b>io.ktor:ktor-server-jetty-jakarta</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> asProvider() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.jetty");
        }

        /**
         * Dependency provider for <b>legacy</b> with <b>io.ktor:ktor-server-jetty</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getLegacy() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.jetty.legacy");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ServerMetricsLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public ServerMetricsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>metrics</b> with <b>io.ktor:ktor-server-metrics</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> asProvider() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.metrics");
        }

        /**
         * Dependency provider for <b>micrometer</b> with <b>io.ktor:ktor-server-metrics-micrometer</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getMicrometer() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.metrics.micrometer");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ServerServletLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public ServerServletLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>servlet</b> with <b>io.ktor:ktor-server-servlet-jakarta</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> asProvider() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.servlet");
        }

        /**
         * Dependency provider for <b>legacy</b> with <b>io.ktor:ktor-server-servlet</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getLegacy() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.servlet.legacy");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ServerTomcatLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public ServerTomcatLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>tomcat</b> with <b>io.ktor:ktor-server-tomcat-jakarta</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> asProvider() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.tomcat");
        }

        /**
         * Dependency provider for <b>legacy</b> with <b>io.ktor:ktor-server-tomcat</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getLegacy() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("server.tomcat.legacy");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class WebsocketsLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public WebsocketsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>websockets</b> with <b>io.ktor:ktor-websockets</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> asProvider() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("websockets");
        }

        /**
         * Dependency provider for <b>serialization</b> with <b>io.ktor:ktor-websocket-serialization</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getSerialization() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("websockets.serialization");
        }

    }

    public static class VersionAccessors extends VersionFactory  {

        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>ktor</b> with value <b>3.5.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<String> getKtor() { return getVersion("ktor"); }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

    }

    public static class PluginAccessors extends PluginFactory {

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Plugin provider for <b>ktor</b> with plugin id <b>io.ktor.plugin</b> and
         * with version reference <b>ktor</b>
         * <p>
         * This plugin was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<PluginDependency> getKtor() { return createPlugin("ktor"); }

    }

}
