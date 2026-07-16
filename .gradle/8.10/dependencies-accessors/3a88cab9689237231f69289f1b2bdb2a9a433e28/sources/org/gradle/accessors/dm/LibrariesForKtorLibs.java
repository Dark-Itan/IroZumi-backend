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
public class LibrariesForKtorLibs extends AbstractExternalDependencyFactory {

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
    public LibrariesForKtorLibs(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

    /**
     * Dependency provider for <b>bom</b> with <b>io.ktor:ktor-bom</b> coordinates and
     * with version reference <b>ktor</b>
     * <p>
     * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
     */
    public Provider<MinimalExternalModuleDependency> getBom() {
        return create("bom");
    }

    /**
     * Dependency provider for <b>callId</b> with <b>io.ktor:ktor-call-id</b> coordinates and
     * with version reference <b>ktor</b>
     * <p>
     * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
     */
    public Provider<MinimalExternalModuleDependency> getCallId() {
        return create("callId");
    }

    /**
     * Dependency provider for <b>compilerPlugin</b> with <b>io.ktor:ktor-compiler-plugin</b> coordinates and
     * with version reference <b>ktor</b>
     * <p>
     * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
     */
    public Provider<MinimalExternalModuleDependency> getCompilerPlugin() {
        return create("compilerPlugin");
    }

    /**
     * Dependency provider for <b>encodingZstd</b> with <b>io.ktor:ktor-encoding-zstd</b> coordinates and
     * with version reference <b>ktor</b>
     * <p>
     * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
     */
    public Provider<MinimalExternalModuleDependency> getEncodingZstd() {
        return create("encodingZstd");
    }

    /**
     * Dependency provider for <b>events</b> with <b>io.ktor:ktor-events</b> coordinates and
     * with version reference <b>ktor</b>
     * <p>
     * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
     */
    public Provider<MinimalExternalModuleDependency> getEvents() {
        return create("events");
    }

    /**
     * Dependency provider for <b>gradlePlugin</b> with <b>io.ktor.plugin:plugin</b> coordinates and
     * with version reference <b>ktor</b>
     * <p>
     * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
     */
    public Provider<MinimalExternalModuleDependency> getGradlePlugin() {
        return create("gradlePlugin");
    }

    /**
     * Dependency provider for <b>io</b> with <b>io.ktor:ktor-io</b> coordinates and
     * with version reference <b>ktor</b>
     * <p>
     * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
     */
    public Provider<MinimalExternalModuleDependency> getIo() {
        return create("io");
    }

    /**
     * Dependency provider for <b>resources</b> with <b>io.ktor:ktor-resources</b> coordinates and
     * with version reference <b>ktor</b>
     * <p>
     * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
     */
    public Provider<MinimalExternalModuleDependency> getResources() {
        return create("resources");
    }

    /**
     * Dependency provider for <b>sse</b> with <b>io.ktor:ktor-sse</b> coordinates and
     * with version reference <b>ktor</b>
     * <p>
     * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
     */
    public Provider<MinimalExternalModuleDependency> getSse() {
        return create("sse");
    }

    /**
     * Dependency provider for <b>testDispatcher</b> with <b>io.ktor:ktor-test-dispatcher</b> coordinates and
     * with version reference <b>ktor</b>
     * <p>
     * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
     */
    public Provider<MinimalExternalModuleDependency> getTestDispatcher() {
        return create("testDispatcher");
    }

    /**
     * Dependency provider for <b>utils</b> with <b>io.ktor:ktor-utils</b> coordinates and
     * with version reference <b>ktor</b>
     * <p>
     * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
     */
    public Provider<MinimalExternalModuleDependency> getUtils() {
        return create("utils");
    }

    /**
     * Group of libraries at <b>client</b>
     */
    public ClientLibraryAccessors getClient() {
        return laccForClientLibraryAccessors;
    }

    /**
     * Group of libraries at <b>htmx</b>
     */
    public HtmxLibraryAccessors getHtmx() {
        return laccForHtmxLibraryAccessors;
    }

    /**
     * Group of libraries at <b>http</b>
     */
    public HttpLibraryAccessors getHttp() {
        return laccForHttpLibraryAccessors;
    }

    /**
     * Group of libraries at <b>network</b>
     */
    public NetworkLibraryAccessors getNetwork() {
        return laccForNetworkLibraryAccessors;
    }

    /**
     * Group of libraries at <b>openapiSchema</b>
     */
    public OpenapiSchemaLibraryAccessors getOpenapiSchema() {
        return laccForOpenapiSchemaLibraryAccessors;
    }

    /**
     * Group of libraries at <b>serialization</b>
     */
    public SerializationLibraryAccessors getSerialization() {
        return laccForSerializationLibraryAccessors;
    }

    /**
     * Group of libraries at <b>server</b>
     */
    public ServerLibraryAccessors getServer() {
        return laccForServerLibraryAccessors;
    }

    /**
     * Group of libraries at <b>websockets</b>
     */
    public WebsocketsLibraryAccessors getWebsockets() {
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
     */
    public BundleAccessors getBundles() {
        return baccForBundleAccessors;
    }

    /**
     * Group of plugins at <b>plugins</b>
     */
    public PluginAccessors getPlugins() {
        return paccForPluginAccessors;
    }

    public static class ClientLibraryAccessors extends SubDependencyFactory {
        private final ClientDarwinLibraryAccessors laccForClientDarwinLibraryAccessors = new ClientDarwinLibraryAccessors(owner);
        private final ClientJettyLibraryAccessors laccForClientJettyLibraryAccessors = new ClientJettyLibraryAccessors(owner);

        public ClientLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>android</b> with <b>io.ktor:ktor-client-android</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getAndroid() {
            return create("client.android");
        }

        /**
         * Dependency provider for <b>apache</b> with <b>io.ktor:ktor-client-apache</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getApache() {
            return create("client.apache");
        }

        /**
         * Dependency provider for <b>apache5</b> with <b>io.ktor:ktor-client-apache5</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getApache5() {
            return create("client.apache5");
        }

        /**
         * Dependency provider for <b>auth</b> with <b>io.ktor:ktor-client-auth</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getAuth() {
            return create("client.auth");
        }

        /**
         * Dependency provider for <b>bomRemover</b> with <b>io.ktor:ktor-client-bom-remover</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getBomRemover() {
            return create("client.bomRemover");
        }

        /**
         * Dependency provider for <b>callId</b> with <b>io.ktor:ktor-client-call-id</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getCallId() {
            return create("client.callId");
        }

        /**
         * Dependency provider for <b>cio</b> with <b>io.ktor:ktor-client-cio</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getCio() {
            return create("client.cio");
        }

        /**
         * Dependency provider for <b>contentNegotiation</b> with <b>io.ktor:ktor-client-content-negotiation</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getContentNegotiation() {
            return create("client.contentNegotiation");
        }

        /**
         * Dependency provider for <b>core</b> with <b>io.ktor:ktor-client-core</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getCore() {
            return create("client.core");
        }

        /**
         * Dependency provider for <b>curl</b> with <b>io.ktor:ktor-client-curl</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getCurl() {
            return create("client.curl");
        }

        /**
         * Dependency provider for <b>encoding</b> with <b>io.ktor:ktor-client-encoding</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getEncoding() {
            return create("client.encoding");
        }

        /**
         * Dependency provider for <b>gson</b> with <b>io.ktor:ktor-client-gson</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getGson() {
            return create("client.gson");
        }

        /**
         * Dependency provider for <b>ios</b> with <b>io.ktor:ktor-client-ios</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getIos() {
            return create("client.ios");
        }

        /**
         * Dependency provider for <b>jackson</b> with <b>io.ktor:ktor-client-jackson</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getJackson() {
            return create("client.jackson");
        }

        /**
         * Dependency provider for <b>java</b> with <b>io.ktor:ktor-client-java</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getJava() {
            return create("client.java");
        }

        /**
         * Dependency provider for <b>js</b> with <b>io.ktor:ktor-client-js</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getJs() {
            return create("client.js");
        }

        /**
         * Dependency provider for <b>json</b> with <b>io.ktor:ktor-client-json</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getJson() {
            return create("client.json");
        }

        /**
         * Dependency provider for <b>logging</b> with <b>io.ktor:ktor-client-logging</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getLogging() {
            return create("client.logging");
        }

        /**
         * Dependency provider for <b>mock</b> with <b>io.ktor:ktor-client-mock</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getMock() {
            return create("client.mock");
        }

        /**
         * Dependency provider for <b>okhttp</b> with <b>io.ktor:ktor-client-okhttp</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getOkhttp() {
            return create("client.okhttp");
        }

        /**
         * Dependency provider for <b>resources</b> with <b>io.ktor:ktor-client-resources</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getResources() {
            return create("client.resources");
        }

        /**
         * Dependency provider for <b>serialization</b> with <b>io.ktor:ktor-client-serialization</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getSerialization() {
            return create("client.serialization");
        }

        /**
         * Dependency provider for <b>webrtc</b> with <b>io.ktor:ktor-client-webrtc</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getWebrtc() {
            return create("client.webrtc");
        }

        /**
         * Dependency provider for <b>websockets</b> with <b>io.ktor:ktor-client-websockets</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getWebsockets() {
            return create("client.websockets");
        }

        /**
         * Dependency provider for <b>winhttp</b> with <b>io.ktor:ktor-client-winhttp</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getWinhttp() {
            return create("client.winhttp");
        }

        /**
         * Group of libraries at <b>client.darwin</b>
         */
        public ClientDarwinLibraryAccessors getDarwin() {
            return laccForClientDarwinLibraryAccessors;
        }

        /**
         * Group of libraries at <b>client.jetty</b>
         */
        public ClientJettyLibraryAccessors getJetty() {
            return laccForClientJettyLibraryAccessors;
        }

    }

    public static class ClientDarwinLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public ClientDarwinLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>darwin</b> with <b>io.ktor:ktor-client-darwin</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("client.darwin");
        }

        /**
         * Dependency provider for <b>legacy</b> with <b>io.ktor:ktor-client-darwin-legacy</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getLegacy() {
            return create("client.darwin.legacy");
        }

    }

    public static class ClientJettyLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public ClientJettyLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>jetty</b> with <b>io.ktor:ktor-client-jetty-jakarta</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("client.jetty");
        }

        /**
         * Dependency provider for <b>legacy</b> with <b>io.ktor:ktor-client-jetty</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getLegacy() {
            return create("client.jetty.legacy");
        }

    }

    public static class HtmxLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public HtmxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>htmx</b> with <b>io.ktor:ktor-htmx</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("htmx");
        }

        /**
         * Dependency provider for <b>html</b> with <b>io.ktor:ktor-htmx-html</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getHtml() {
            return create("htmx.html");
        }

    }

    public static class HttpLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public HttpLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>http</b> with <b>io.ktor:ktor-http</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("http");
        }

        /**
         * Dependency provider for <b>cio</b> with <b>io.ktor:ktor-http-cio</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getCio() {
            return create("http.cio");
        }

    }

    public static class NetworkLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {
        private final NetworkTlsLibraryAccessors laccForNetworkTlsLibraryAccessors = new NetworkTlsLibraryAccessors(owner);

        public NetworkLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>network</b> with <b>io.ktor:ktor-network</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("network");
        }

        /**
         * Group of libraries at <b>network.tls</b>
         */
        public NetworkTlsLibraryAccessors getTls() {
            return laccForNetworkTlsLibraryAccessors;
        }

    }

    public static class NetworkTlsLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public NetworkTlsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>tls</b> with <b>io.ktor:ktor-network-tls</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("network.tls");
        }

        /**
         * Dependency provider for <b>certificates</b> with <b>io.ktor:ktor-network-tls-certificates</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getCertificates() {
            return create("network.tls.certificates");
        }

    }

    public static class OpenapiSchemaLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public OpenapiSchemaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>openapiSchema</b> with <b>io.ktor:ktor-openapi-schema</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("openapiSchema");
        }

        /**
         * Dependency provider for <b>reflect</b> with <b>io.ktor:ktor-openapi-schema-reflect</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getReflect() {
            return create("openapiSchema.reflect");
        }

    }

    public static class SerializationLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {
        private final SerializationKotlinxLibraryAccessors laccForSerializationKotlinxLibraryAccessors = new SerializationKotlinxLibraryAccessors(owner);

        public SerializationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>serialization</b> with <b>io.ktor:ktor-serialization</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("serialization");
        }

        /**
         * Dependency provider for <b>gson</b> with <b>io.ktor:ktor-serialization-gson</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getGson() {
            return create("serialization.gson");
        }

        /**
         * Dependency provider for <b>jackson</b> with <b>io.ktor:ktor-serialization-jackson</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getJackson() {
            return create("serialization.jackson");
        }

        /**
         * Dependency provider for <b>jackson3</b> with <b>io.ktor:ktor-serialization-jackson3</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getJackson3() {
            return create("serialization.jackson3");
        }

        /**
         * Group of libraries at <b>serialization.kotlinx</b>
         */
        public SerializationKotlinxLibraryAccessors getKotlinx() {
            return laccForSerializationKotlinxLibraryAccessors;
        }

    }

    public static class SerializationKotlinxLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public SerializationKotlinxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>kotlinx</b> with <b>io.ktor:ktor-serialization-kotlinx</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("serialization.kotlinx");
        }

        /**
         * Dependency provider for <b>cbor</b> with <b>io.ktor:ktor-serialization-kotlinx-cbor</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getCbor() {
            return create("serialization.kotlinx.cbor");
        }

        /**
         * Dependency provider for <b>json</b> with <b>io.ktor:ktor-serialization-kotlinx-json</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getJson() {
            return create("serialization.kotlinx.json");
        }

        /**
         * Dependency provider for <b>protobuf</b> with <b>io.ktor:ktor-serialization-kotlinx-protobuf</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getProtobuf() {
            return create("serialization.kotlinx.protobuf");
        }

        /**
         * Dependency provider for <b>xml</b> with <b>io.ktor:ktor-serialization-kotlinx-xml</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getXml() {
            return create("serialization.kotlinx.xml");
        }

    }

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
         */
        public Provider<MinimalExternalModuleDependency> getAutoHeadResponse() {
            return create("server.autoHeadResponse");
        }

        /**
         * Dependency provider for <b>bodyLimit</b> with <b>io.ktor:ktor-server-body-limit</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getBodyLimit() {
            return create("server.bodyLimit");
        }

        /**
         * Dependency provider for <b>cachingHeaders</b> with <b>io.ktor:ktor-server-caching-headers</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getCachingHeaders() {
            return create("server.cachingHeaders");
        }

        /**
         * Dependency provider for <b>callId</b> with <b>io.ktor:ktor-server-call-id</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getCallId() {
            return create("server.callId");
        }

        /**
         * Dependency provider for <b>callLogging</b> with <b>io.ktor:ktor-server-call-logging</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getCallLogging() {
            return create("server.callLogging");
        }

        /**
         * Dependency provider for <b>cio</b> with <b>io.ktor:ktor-server-cio</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getCio() {
            return create("server.cio");
        }

        /**
         * Dependency provider for <b>conditionalHeaders</b> with <b>io.ktor:ktor-server-conditional-headers</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getConditionalHeaders() {
            return create("server.conditionalHeaders");
        }

        /**
         * Dependency provider for <b>contentNegotiation</b> with <b>io.ktor:ktor-server-content-negotiation</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getContentNegotiation() {
            return create("server.contentNegotiation");
        }

        /**
         * Dependency provider for <b>core</b> with <b>io.ktor:ktor-server-core</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getCore() {
            return create("server.core");
        }

        /**
         * Dependency provider for <b>cors</b> with <b>io.ktor:ktor-server-cors</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getCors() {
            return create("server.cors");
        }

        /**
         * Dependency provider for <b>csrf</b> with <b>io.ktor:ktor-server-csrf</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getCsrf() {
            return create("server.csrf");
        }

        /**
         * Dependency provider for <b>dataConversion</b> with <b>io.ktor:ktor-server-data-conversion</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getDataConversion() {
            return create("server.dataConversion");
        }

        /**
         * Dependency provider for <b>defaultHeaders</b> with <b>io.ktor:ktor-server-default-headers</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getDefaultHeaders() {
            return create("server.defaultHeaders");
        }

        /**
         * Dependency provider for <b>di</b> with <b>io.ktor:ktor-server-di</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getDi() {
            return create("server.di");
        }

        /**
         * Dependency provider for <b>doubleReceive</b> with <b>io.ktor:ktor-server-double-receive</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getDoubleReceive() {
            return create("server.doubleReceive");
        }

        /**
         * Dependency provider for <b>forwardedHeader</b> with <b>io.ktor:ktor-server-forwarded-header</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getForwardedHeader() {
            return create("server.forwardedHeader");
        }

        /**
         * Dependency provider for <b>freemarker</b> with <b>io.ktor:ktor-server-freemarker</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getFreemarker() {
            return create("server.freemarker");
        }

        /**
         * Dependency provider for <b>hsts</b> with <b>io.ktor:ktor-server-hsts</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getHsts() {
            return create("server.hsts");
        }

        /**
         * Dependency provider for <b>htmlBuilder</b> with <b>io.ktor:ktor-server-html-builder</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getHtmlBuilder() {
            return create("server.htmlBuilder");
        }

        /**
         * Dependency provider for <b>htmx</b> with <b>io.ktor:ktor-server-htmx</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getHtmx() {
            return create("server.htmx");
        }

        /**
         * Dependency provider for <b>httpRedirect</b> with <b>io.ktor:ktor-server-http-redirect</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getHttpRedirect() {
            return create("server.httpRedirect");
        }

        /**
         * Dependency provider for <b>i18n</b> with <b>io.ktor:ktor-server-i18n</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getI18n() {
            return create("server.i18n");
        }

        /**
         * Dependency provider for <b>jte</b> with <b>io.ktor:ktor-server-jte</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getJte() {
            return create("server.jte");
        }

        /**
         * Dependency provider for <b>methodOverride</b> with <b>io.ktor:ktor-server-method-override</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getMethodOverride() {
            return create("server.methodOverride");
        }

        /**
         * Dependency provider for <b>mustache</b> with <b>io.ktor:ktor-server-mustache</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getMustache() {
            return create("server.mustache");
        }

        /**
         * Dependency provider for <b>netty</b> with <b>io.ktor:ktor-server-netty</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getNetty() {
            return create("server.netty");
        }

        /**
         * Dependency provider for <b>openapi</b> with <b>io.ktor:ktor-server-openapi</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getOpenapi() {
            return create("server.openapi");
        }

        /**
         * Dependency provider for <b>partialContent</b> with <b>io.ktor:ktor-server-partial-content</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getPartialContent() {
            return create("server.partialContent");
        }

        /**
         * Dependency provider for <b>pebble</b> with <b>io.ktor:ktor-server-pebble</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getPebble() {
            return create("server.pebble");
        }

        /**
         * Dependency provider for <b>rateLimit</b> with <b>io.ktor:ktor-server-rate-limit</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getRateLimit() {
            return create("server.rateLimit");
        }

        /**
         * Dependency provider for <b>requestValidation</b> with <b>io.ktor:ktor-server-request-validation</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getRequestValidation() {
            return create("server.requestValidation");
        }

        /**
         * Dependency provider for <b>resources</b> with <b>io.ktor:ktor-server-resources</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getResources() {
            return create("server.resources");
        }

        /**
         * Dependency provider for <b>routingOpenapi</b> with <b>io.ktor:ktor-server-routing-openapi</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getRoutingOpenapi() {
            return create("server.routingOpenapi");
        }

        /**
         * Dependency provider for <b>sessions</b> with <b>io.ktor:ktor-server-sessions</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getSessions() {
            return create("server.sessions");
        }

        /**
         * Dependency provider for <b>sse</b> with <b>io.ktor:ktor-server-sse</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getSse() {
            return create("server.sse");
        }

        /**
         * Dependency provider for <b>statusPages</b> with <b>io.ktor:ktor-server-status-pages</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getStatusPages() {
            return create("server.statusPages");
        }

        /**
         * Dependency provider for <b>swagger</b> with <b>io.ktor:ktor-server-swagger</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getSwagger() {
            return create("server.swagger");
        }

        /**
         * Dependency provider for <b>testHost</b> with <b>io.ktor:ktor-server-test-host</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getTestHost() {
            return create("server.testHost");
        }

        /**
         * Dependency provider for <b>thymeleaf</b> with <b>io.ktor:ktor-server-thymeleaf</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getThymeleaf() {
            return create("server.thymeleaf");
        }

        /**
         * Dependency provider for <b>velocity</b> with <b>io.ktor:ktor-server-velocity</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getVelocity() {
            return create("server.velocity");
        }

        /**
         * Dependency provider for <b>webjars</b> with <b>io.ktor:ktor-server-webjars</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getWebjars() {
            return create("server.webjars");
        }

        /**
         * Dependency provider for <b>websockets</b> with <b>io.ktor:ktor-server-websockets</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getWebsockets() {
            return create("server.websockets");
        }

        /**
         * Group of libraries at <b>server.auth</b>
         */
        public ServerAuthLibraryAccessors getAuth() {
            return laccForServerAuthLibraryAccessors;
        }

        /**
         * Group of libraries at <b>server.compression</b>
         */
        public ServerCompressionLibraryAccessors getCompression() {
            return laccForServerCompressionLibraryAccessors;
        }

        /**
         * Group of libraries at <b>server.config</b>
         */
        public ServerConfigLibraryAccessors getConfig() {
            return laccForServerConfigLibraryAccessors;
        }

        /**
         * Group of libraries at <b>server.jetty</b>
         */
        public ServerJettyLibraryAccessors getJetty() {
            return laccForServerJettyLibraryAccessors;
        }

        /**
         * Group of libraries at <b>server.metrics</b>
         */
        public ServerMetricsLibraryAccessors getMetrics() {
            return laccForServerMetricsLibraryAccessors;
        }

        /**
         * Group of libraries at <b>server.servlet</b>
         */
        public ServerServletLibraryAccessors getServlet() {
            return laccForServerServletLibraryAccessors;
        }

        /**
         * Group of libraries at <b>server.tomcat</b>
         */
        public ServerTomcatLibraryAccessors getTomcat() {
            return laccForServerTomcatLibraryAccessors;
        }

    }

    public static class ServerAuthLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public ServerAuthLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>auth</b> with <b>io.ktor:ktor-server-auth</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("server.auth");
        }

        /**
         * Dependency provider for <b>apiKey</b> with <b>io.ktor:ktor-server-auth-api-key</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getApiKey() {
            return create("server.auth.apiKey");
        }

        /**
         * Dependency provider for <b>jwt</b> with <b>io.ktor:ktor-server-auth-jwt</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getJwt() {
            return create("server.auth.jwt");
        }

        /**
         * Dependency provider for <b>ldap</b> with <b>io.ktor:ktor-server-auth-ldap</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getLdap() {
            return create("server.auth.ldap");
        }

    }

    public static class ServerCompressionLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public ServerCompressionLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>compression</b> with <b>io.ktor:ktor-server-compression</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("server.compression");
        }

        /**
         * Dependency provider for <b>zstd</b> with <b>io.ktor:ktor-server-compression-zstd</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getZstd() {
            return create("server.compression.zstd");
        }

    }

    public static class ServerConfigLibraryAccessors extends SubDependencyFactory {

        public ServerConfigLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>yaml</b> with <b>io.ktor:ktor-server-config-yaml</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getYaml() {
            return create("server.config.yaml");
        }

    }

    public static class ServerJettyLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public ServerJettyLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>jetty</b> with <b>io.ktor:ktor-server-jetty-jakarta</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("server.jetty");
        }

        /**
         * Dependency provider for <b>legacy</b> with <b>io.ktor:ktor-server-jetty</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getLegacy() {
            return create("server.jetty.legacy");
        }

    }

    public static class ServerMetricsLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public ServerMetricsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>metrics</b> with <b>io.ktor:ktor-server-metrics</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("server.metrics");
        }

        /**
         * Dependency provider for <b>micrometer</b> with <b>io.ktor:ktor-server-metrics-micrometer</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getMicrometer() {
            return create("server.metrics.micrometer");
        }

    }

    public static class ServerServletLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public ServerServletLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>servlet</b> with <b>io.ktor:ktor-server-servlet-jakarta</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("server.servlet");
        }

        /**
         * Dependency provider for <b>legacy</b> with <b>io.ktor:ktor-server-servlet</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getLegacy() {
            return create("server.servlet.legacy");
        }

    }

    public static class ServerTomcatLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public ServerTomcatLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>tomcat</b> with <b>io.ktor:ktor-server-tomcat-jakarta</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("server.tomcat");
        }

        /**
         * Dependency provider for <b>legacy</b> with <b>io.ktor:ktor-server-tomcat</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getLegacy() {
            return create("server.tomcat.legacy");
        }

    }

    public static class WebsocketsLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public WebsocketsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>websockets</b> with <b>io.ktor:ktor-websockets</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("websockets");
        }

        /**
         * Dependency provider for <b>serialization</b> with <b>io.ktor:ktor-websocket-serialization</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog io.ktor:ktor-version-catalog:3.5.0
         */
        public Provider<MinimalExternalModuleDependency> getSerialization() {
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
